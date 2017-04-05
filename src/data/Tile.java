package data;

import org.newdawn.slick.opengl.Texture;

import helper.Artist;

public class Tile {
	
	private float x;
	private float y; 
	private float width; 
	private float height;
	
	private TileType type;
	private Texture texture;

	public Tile(float x, float y, float width, float height, TileType type) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		this.texture = Artist.quickLoad(type.textureName);
	}
	
	public void draw(){
		Artist.drawQuadText(texture, x, y, width, height);
	}

	public float getX() {
		return x;
	}
	
	public int getXPlace(){
		return (int) x/64;
	}
	
	public int getYPlace(){
		return (int) y/64;
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

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	

}
