package dev.tristan.babygame.states;

import java.awt.Graphics;

import dev.tristan.babygame.Game;
import dev.tristan.babygame.Handler;

public abstract class State {
	
	
	//Game state manager
	private static State currentState= null;
	
	public static void setState (State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	//Class
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
