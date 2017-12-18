package pingPong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ScoreBoard {
	
	private int p1Score;
	private int p2Score;
	
	public int getP1Score() {
		return p1Score;
	}
	
	public int getP2Score() {
		return p2Score;
	}
	
	
	public void addPoints(int player){
		if(player == 1){
			p1Score++;
		}
		else {
			p2Score++;
		}
	}
	
	public void resetScore(){
		p1Score=0;
		p2Score=0;
	}
	
	
	public void paintComponent(Graphics g, Board board) {
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 100)); 
		g.drawString(Integer.toString(p1Score), board.getWidth()/2-200, 100);
		g.drawString(Integer.toString(p2Score), board.getWidth()/2+150, 100);
	}

}
