package data;

import org.lwjgl.opengl.Display;
//import org.newdawn.slick.opengl.Texture;

import helper.Artist;
import helper.Clock;


public class Boot {

	public Boot(){
		
		Artist.beginSession();
		
		int[][] map = {
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,1},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,1},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,0,1},
				{0,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1},
				{0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				//{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				//{0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0},
				//{0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
				//{0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0},
				//{0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0},
		};
		
		TileGrid grid = new TileGrid(map);
		grid.setTile(3, 4, grid.getTile(5, 7).getType());
		//Enemy e = new Enemy(Artist.quickLoad("timeAzulSoldado"),grid.getTile(4, 4),grid, 50, 50, 5);
		Enemy e = new Enemy(Artist.quickLoad("skeleton64"),grid.getTile(5, 4),grid, 64, 64, 6);
		Wave wave = new Wave(20, e);
		Player player = new Player(grid);
		while(!Display.isCloseRequested()){
			
			Clock.update();
		
			grid.draw();
			wave.update();
			//e.update();
			//e.draw();
			player.update();;
	
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Boot();

	}

}
