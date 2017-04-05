package data;

import java.util.ArrayList;

import helper.Clock;

public class Wave {
	private float timeSinceLastSpawn;
	private float spawnTime;
	private Enemy enemyType;
	private ArrayList<Enemy> enemyList;
	

	public Wave(float spawnTime, Enemy enemyType) {
		this.spawnTime = spawnTime;
		this.enemyType = enemyType;
		timeSinceLastSpawn = 0;
		enemyList = new ArrayList<Enemy>();
	}
	
	public void update(){
		timeSinceLastSpawn += Clock.delta();
		if (timeSinceLastSpawn > spawnTime){
			spawn();
			timeSinceLastSpawn = 0;
		}
		
		for (Enemy e: enemyList){
			e.update();
			e.draw();
		}
	}
	
	private void spawn(){
		enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getTileGrid(),64, 64, enemyType.getSpeed()));
	}

}
