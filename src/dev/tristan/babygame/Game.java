package dev.tristan.babygame;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

import dev.tristan.babygame.display.Display;
import dev.tristan.babygame.gfx.Assets;
import dev.tristan.babygame.gfx.GameCamera;
import dev.tristan.babygame.gfx.ImageLoader;
import dev.tristan.babygame.gfx.SpriteSheet;
import dev.tristan.babygame.input.KeyManager;
import dev.tristan.babygame.states.GameState;
import dev.tristan.babygame.states.MenuState;
import dev.tristan.babygame.states.SettingState;
import dev.tristan.babygame.states.State;

public class Game implements Runnable {
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	//States
	private State gameState;
	private State menuState;
	private State settingState;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		settingState = new SettingState(handler);
		State.setState(gameState);
	}
	

	
	private void update(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}

	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		//End Draw
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				update();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000){
				System.out.println("Ticks And Frames: " + ticks);
				ticks = 0;
				timer = 0;		
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if (!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
