package pingPong;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Paddle {
	
	int x, y;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 20, 100);
	}
	

}
