package pingPong;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Paddle {
	
	protected int x;
	protected int y;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 20, 100);
	}
	

}
