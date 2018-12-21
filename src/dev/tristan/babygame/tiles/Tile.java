package dev.tristan.babygame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//Static Stuff Here
	public static Tile[] tiles = new Tile[256];
	public static Tile dirtTile = new DirtTile(0);
	//grass
	public static Tile grassLDTile = new GrassLDTile(1);
	public static Tile grassRDTile = new GrassRDTile(2);
	public static Tile grassLUTile = new GrassLUTile(3);
	public static Tile grassRUTile = new GrassRUTile(4);
	public static Tile grassDTile = new GrassDTile(5);
	public static Tile grassLTile = new GrassLTile(6);
	public static Tile grassUTile = new GrassUTile(7);
	public static Tile grassRTile = new GrassRTile(8);
	//stone
	
	//Class
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
}
