package data;


public class TileGrid {

	private Tile[][] map;
	private int tileWide;
	private int tileHigh;
	
	public TileGrid(){
		map = new Tile[20][15];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j< map[i].length; j++){
				map[i][j] = new Tile(i * 64, j*64, 64, 64, TileType.grass);
			}
		}
	}
	
	public TileGrid(int[][] newMap){
		this.tileWide = newMap[0].length;
		this.tileHigh= newMap.length;
		map = new Tile[tileWide][tileHigh];
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
		if( inBound(xPlace, yPlace)){
			return map[xPlace][yPlace];
		}else{
			return new Tile(0,0,0,0,TileType.nothing);
		}
	}
	
	public boolean inBound(int x, int y){
		boolean answer = true;
		if ((x< 0 || x >= tileWide) || (y<0 || y>=tileHigh))
			answer = false;
		return answer;
	}
	
	public boolean outOfBound(int x, int y){
		boolean answer = false;
		if ((x< 0 || x >= tileWide) || (y<0 || y>=tileHigh))
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
