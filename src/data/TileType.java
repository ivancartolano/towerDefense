package data;

public enum TileType {
	
	grass("grass64", true), dirt("dirt64", false), water("water64",false);
	
	String textureName;
	boolean buildable;
	
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
