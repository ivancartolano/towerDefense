package data;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

import helper.Artist;
import helper.Clock;

public class Enemy {
	private float x;
	private float y;
	private int width;
	private int height;
	private int health;
	private int currentCheckpoint;
	private float speed;
	Texture texture;
	private Tile startTile;
	//private Tile currentTile;
	private boolean first = true;
	private TileGrid grid;
	
	private ArrayList<Checkpoint> checkpoints;
	private int[] directions;
	
	public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed){
		this.startTile = startTile;
		//this.currentTile = startTile;
		this.texture = texture;
		this.x= startTile.getX();
		this.y= startTile.getY();
		this.width= width;
		this.height= height;
		this.speed= speed;
		this.grid= grid;
		
		this.checkpoints= new ArrayList<Checkpoint>();
		this.directions = new int[2];
		// index 0 = x axe, index 1 = y axe
		this.directions[0] = 0;
		this.directions[1] = 0;
		this.directions = findNextDirection(startTile);
		this.currentCheckpoint = 0;
		this.pupolateCheckpointList();
	}
	
	public void update(){
		if(first)
			first = false;
		else{
			/**/if(checkpointreached()){
				currentCheckpoint++;
			}// else{
				//x += Clock.delta() * checkpoints.get(currentCheckpoint).getxDirection();
				//y += Clock.delta() * checkpoints.get(currentCheckpoint).getyDirection();
			//}/**/
			//findNextDirection(s);
			x += Clock.delta()* speed * directions[0];
			y += Clock.delta()* speed * directions[1];
		}
	}
	
	private boolean checkpointreached(){
		boolean reached = false;
		Tile t = checkpoints.get(currentCheckpoint).getTile();
		if(x > t.getX() - 7 && x < t.getX() + 7 &&
				y > t.getY() - 7 && y < t.getY() + 7){
			reached = true;
			x = t.getX();
			y = t.getY();
		}
			
		
		return reached;
	}
	
	private void pupolateCheckpointList(){
		//Tile currentTile = startTile;
		checkpoints.add(findNextCheckpoint(startTile, directions = findNextDirection(startTile)));
		
		int counter = 0;
		boolean keepGoing = true;
		while (keepGoing){
			System.out.println("populando");
			int[] currentD = findNextDirection(checkpoints.get(counter).getTile());
			//if (currentD[0] == 2 || grid.outOfBound(checkpoints.get(counter).getTile().getXPlace(), checkpoints.get(counter).getTile().getYPlace())){
			if (currentD[0] == 2 || counter > 20){	
				keepGoing = false;
				System.out.println("vdd");
			} else{
				System.out.println("falso ");
				checkpoints.add(findNextCheckpoint(checkpoints.get(counter).getTile(),
						directions = findNextDirection(checkpoints.get(counter).getTile())));
			}
			counter++;
		}
		for(int i = 0; i < checkpoints.size(); i++){
			System.out.println(counter + " "+ i + "  "+checkpoints.get(i).getTile().getXPlace()+ " "+checkpoints.get(i).getTile().getYPlace() );
		}
	}
	
	private Checkpoint findNextCheckpoint(Tile s, int[] dir){
		Tile next = null;
		Checkpoint c = null;
		
		boolean found = false;
		int counter = 1;
		
		while(!found){
			
			System.out.println("achando next checkpoint");
			
			if(s.getType() != 
					grid.getTile(s.getXPlace()+ dir[0]* counter,
							s.getYPlace() + dir[1]* counter).getType()){
				
				found = true;
				counter -=1;
				next = grid.getTile(s.getXPlace()+ dir[0]* counter,
						s.getYPlace() + dir[1]* counter);
			}
			
			c = new Checkpoint(next, dir[0], dir[1]);
			counter++;
		}
		
		return c;
	}
	
	private int[] findNextDirection(Tile s){
		int[] dir = new int[2];
		Tile up = grid.getTile(s.getXPlace(), s.getYPlace()-1);
		Tile right = grid.getTile(s.getXPlace() + 1, s.getYPlace());
		Tile down = grid.getTile(s.getXPlace(), s.getYPlace()+ 1);
		Tile left = grid.getTile(s.getXPlace()-1, s.getYPlace());
		
		if(s.getType() == up.getType()){
			dir[0] = 0;
			dir[1] = -1;
		} else if (s.getType() == right.getType()){
			dir[0]= 1;
			dir[1]= 0;
		} else if (s.getType() == down.getType()){
			dir[0]= 0;
			dir[1]= 1;
		}else if (s.getType() == left.getType()){
			dir[0]= -1;
			dir[1]= 0;
		}else{
			//dir[0]= 0;
			//dir[1]= 0;
			dir[0]= 2;
			dir[1]= 2;
		}
		return dir;
	}
	
	/*
	public boolean pathContinues(){
		boolean answer = true;
		
		Tile myTile = grid.getTile((int)(x/64),(int)(y/64));
		Tile nextTile = grid.getTile((int)(x/64) + 1,(int)(y/64));
		
		if(myTile.getType() != nextTile.getType()){
			answer = false;
		}
		
		return answer;
	}*/
	
	public void draw(){
		Artist.drawQuadText(texture, x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public TileGrid getTileGrid(){
		return grid;
	}
}
