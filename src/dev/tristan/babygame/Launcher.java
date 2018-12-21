package dev.tristan.babygame;

import dev.tristan.babygame.display.Display;

public class Launcher {
	
	public static void main(String[] args){
		Game game = new Game("Big Willy", 1280, 960);
		game.start();
		
	}
}
