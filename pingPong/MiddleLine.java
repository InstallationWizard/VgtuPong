package pingPong;

import java.awt.Color;
import java.awt.Graphics;

public class MiddleLine {
	
	private Board board;

	void setBoard(Board board) {
		this.board = board;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		for (int i = 0; i < board.getHeight(); i+=40) {
			g.fillRect(board.getWidth()/2-10, i, 10, 20);
		}
	}

}
