package dev.tristan.babygame.states;

import java.awt.Graphics;

import dev.tristan.babygame.Game;
import dev.tristan.babygame.Handler;
import dev.tristan.babygame.entities.creatures.Player;
import dev.tristan.babygame.gfx.Assets;
import dev.tristan.babygame.tiles.Tile;
import dev.tristan.babygame.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler, 100, 100);
		
		
		handler.getGameCamera().move(100, 200);
	}

	public void tick() {
		world.tick();
		player.tick();

	}


	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}
	
	
}
