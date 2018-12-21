package dev.tristan.babygame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 64, height = 64;
	public static BufferedImage player, dirt, grassLD, grassRD, grassLU, grassRU, grassD, grassL, grassU, grassR,
	grassInU, grassInD, grassInR, grassInL, grassInLD, grassInRD, grassInRU, grassInLU;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/sheet.png"));
		
		player = sheet.crop(4*width, height, width, height);
		dirt = sheet.crop(4*width, 0, width, height);
		grassLD  = sheet.crop(0, 0, width, height);
		grassRD = sheet.crop(width, 0, width, height);
		grassLU = sheet.crop(2*width, 0, width, height);
		grassRU = sheet.crop(3*width, 0, width, height);
		grassD  = sheet.crop(0, height, width, height);
		grassL = sheet.crop(width, height, width, height);
		grassU = sheet.crop(2*width, height, width, height);
		grassR = sheet.crop(3*width, height, width, height);
		grassInU = sheet.crop(0, 2*height, width, height);
		grassInD = sheet.crop(width, 2*height, width, height);
		grassInR = sheet.crop(2*width, 2*height, width, height);
		grassInL = sheet.crop(3*width, 2*height, width, height);
		grassInLD = sheet.crop(4*width, 2*height, width, height);
		grassInRD = sheet.crop(0, 3*height, width, height);
		grassInRU = sheet.crop(width, 3*height, width, height);
		grassInLU = sheet.crop(2*width, 3*height, width, height);
		
	}
}
