package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import static helper.Artist.HEIGHT;

public class Player {
	private TileGrid grid;
	private TileType[] types;
	private int index;
	
	public Player(TileGrid grid){
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.grass;
		this.types[1] = TileType.dirt;
		this.types[2] = TileType.water;
		this.index = 0;
	}
	
	public void setTile(){
		grid.setTile((int)(Math.floor(Mouse.getX()/64)), 
				(int)Math.floor((HEIGHT - Mouse.getY() - 1)/64), types[index]);
	}
	
	public void update(){
		if(Mouse.isButtonDown(0)){
			setTile();
		}
		while (Keyboard.next()){
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT){
				moveIndex();
			}
		}
	}
	
	public void moveIndex(){
		index++;
		if(index > types.length - 1){
			index = 0;
		}
	}

}
