package helper;

import org.lwjgl.Sys;

public class Clock {
	private static boolean paused = false;
	public static long lastFrame;
	public static long totalTime;
	public static float deltaTime = 0;
	public static float multiplier = 1;
	
	public static long getTime(){
		return Sys.getTime()* 1000/ Sys.getTimerResolution();
	}
	
	public static float getDelta(){
		long currentTime = getTime();
		int delta = (int)(currentTime - lastFrame);
		lastFrame = getTime();
		if (delta * 0.01f > 0.5f)//melhorar
			return 0.5f;
		return delta * 0.01f;
	}
	
	public static float delta(){
		if(paused)
			return 0;
		else
			return deltaTime* multiplier;
	}
	
	public static float totalTime(){
		return totalTime;
	}
	
	public static float Multiplier(){
		return multiplier;
	}
	
	public static void update(){
		deltaTime= getDelta();
		totalTime += deltaTime;
	}
	
	public static void changeMultiplier(int change){
		if (multiplier + change < -1 || multiplier + change> 7){
			
		}else{
			multiplier += change;
		}			
	}
	
	public static void pause(){
		if(paused)
			paused = false;
		else
			paused= true;
	}
}
