package data;

//import helper.Artist;

public class TileGrid {

	public Tile[][] map;
	
	public TileGrid(){
		map = new Tile[20][15];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j< map[i].length; j++){
				map[i][j] = new Tile(i * 64, j*64, 64, 64, TileType.grass);
			}
		}
	}
	
	public TileGrid(int[][] newMap){
		//map = new Tile[20][15];
		map = new Tile[20][10];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j< map[i].length; j++){
				map[i][j] = new Tile(i * 64, j*64, 64, 64, TileType.grass);
				switch(newMap[j][i]){
					case 0 :
						map[i][j] = new Tile(i * 64, j*64, 64, 64, TileType.grass);
						break;
					case 1:
						map[i][j] = new Tile(i * 64, j*64, 64, 64, TileType.dirt);
						break;
					case 2:
						map[i][j] = new Tile(i * 64, j*64, 64, 64, TileType.water);
						break;
				}
			}
		}
	}
	
	public void setTile(int xCoord, int yCoord, TileType type){
		map[xCoord][yCoord] = new Tile(xCoord*64, yCoord*64, 64, 64, type);
	}
	
	public Tile getTile(int xPlace, int yPlace){
		return map[xPlace][yPlace];
	}
	
	public boolean inBound(int x, int y){
		boolean answer = true;
		if ((x< 0 || x > 20) || (y<0 || y>10))
			answer = false;
		return answer;
	}
	
	public boolean outOfBound(int x, int y){
		boolean answer = false;
		if ((x< 0 || x > 20) || (y<0 || y>10))
			answer = true;
		return answer;
	}
	
	public void draw(){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j< map[i].length; j++){
				map[i][j].draw();;
			}
		}
	}
	
}
