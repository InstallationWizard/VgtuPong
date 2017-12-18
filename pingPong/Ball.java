package pingPong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int x, y;
	private int xVelocity, yVelocity;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Ball() {
		//x = board.getWidth()/2;
		//y = board.getHeight()/2;
		
		x = 480;
		y = 360;
		yVelocity = -2;
		xVelocity = -3;
	}
	
	public void resetBallPosition(int direction) {
		x = 450;
		y = 450;
		yVelocity = -1;
		xVelocity = -3 * direction ;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x-10, y-10, 20, 20);
	}
	
	public void checkCollision(Paddle player1, Paddle player2, Board board) {
		if (x <= 50 && x > 40 && (y >= player1.y  && y <= player1.y+100 )){
			double relativeIntersectY = (player1.y+50) - y;
			double normalizedRelativeIntersectionY = (relativeIntersectY/50);
			double bounceAngle = normalizedRelativeIntersectionY * 5*3.14159/12;
			yVelocity = (int) (4*-Math.sin(bounceAngle));
			xVelocity = (int) (4*Math.cos(bounceAngle));
		}
		else if (x >= board.getWidth()-40 && x < board.getWidth()-30  && (y >= player2.y  && y <= player2.y+100 )){
			double relativeIntersectY = (player2.y+50) - y;
			double normalizedRelativeIntersectionY = (relativeIntersectY/50);
			double bounceAngle = normalizedRelativeIntersectionY * 5*3.14159/12;
			yVelocity = (int) (4*-Math.sin(bounceAngle));
			xVelocity = (int) (-4*Math.cos(bounceAngle));
		}
	}
	
	public void move(Board board, ScoreBoard scoreBoard) {
		x+=xVelocity;
		y+=yVelocity;
		if (y> board.getHeight() - 10 || y < 10 ) {
			yVelocity *= -1;
		}
	}

	public void checkIfScored(Board board, ScoreBoard scoreBoard) {
		if ( x > board.getWidth()-10 ) {
			scoreBoard.addPoints(1);
			resetBallPosition(1);
		}
		else if ( x < 10 ) {
			scoreBoard.addPoints(2);
			resetBallPosition(-1);
		}
	}
	
	
}
