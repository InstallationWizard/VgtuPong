package pingPong;

import java.awt.Graphics;

public class BoardRenderer {
	
	
	public void paintPaddle(Graphics g, Paddle paddle) {
		paddle.paintComponent(g);
	}
	
	public void paintBall(Graphics g, Ball ball) {
		ball.paintComponent(g);
	}
	
	public void paintMiddleLine(Graphics g, MiddleLine middleLine) {
		middleLine.paintComponent(g);
	}
	public void paintScoreBoard(Graphics g, ScoreBoard scoreBoard, Board board) {
		scoreBoard.paintComponent(g, board);
	}
	

}
