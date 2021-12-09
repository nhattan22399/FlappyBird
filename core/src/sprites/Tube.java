package sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;

import java.util.Random;

public class Tube {
	public static final int TUBE_WIDTH = 52;
	private static final int FLUCTUATION = 120;
	private static final int TUBE_GAP = 80;
	private static final int LOWEST_OPENING = 110;
	private Texture topTube, botTube;
	private Vector2 posTopTube, posBotTube;
	private Rectangle bounsTop, bounsBot;
	private java.util.Random rd;
	
	private boolean isBehindBird= false;
	
	
	public Tube(float x) {
		topTube = new Texture("toptube.png");
		botTube = new Texture("bottomtube.png");
		rd = new Random();
		
		
		posTopTube = new Vector2(x, rd.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
		posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - botTube.getHeight());
		
		
		bounsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(),topTube.getHeight());
		bounsBot = new Rectangle(posBotTube.x, posBotTube.y, botTube.getWidth(),botTube.getHeight());
		
	}


	public Texture getTopTube() {
		return topTube;
	}


	public Texture getBotTube() {
		return botTube;
	}

	public Vector2 getPosTopTube() {
		return posTopTube;
	}


	public Vector2 getPosBotTube() {
		return posBotTube;
	}
	public void reposition(float x) {
		posTopTube.set(x, rd.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
		posBotTube.set(x, posTopTube.y - TUBE_GAP - botTube.getHeight());
		bounsTop.setPosition(posTopTube.x, posTopTube.y);
		bounsBot.setPosition(posBotTube.x, posBotTube.y);
		
	}
	public  void setIsBehindBird(boolean b) {
		isBehindBird = b;
	}
	public boolean getIsBehindBird() {
		return isBehindBird;
	}
	public boolean collides(Rectangle player) {
		return player.overlaps(bounsTop) || player.overlaps(bounsBot);
	}
	public void dispose() {
		topTube.dispose();
		botTube.dispose();
	}
}
