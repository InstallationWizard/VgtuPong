package pingPong;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests {

	@Test
	void testPointAdding() {
		ScoreBoard sb = new ScoreBoard();
		sb.addPoints(1);
		assertEquals(1, sb.getP1Score());
		sb.addPoints(2);
		assertEquals(1, sb.getP2Score());
		sb.addPoints(1);
		assertEquals(2, sb.getP1Score());
	}
	
	@Test
	void testScoreReset() {
		ScoreBoard sb = new ScoreBoard();
		sb.addPoints(1);
		assertEquals(1, sb.getP1Score());
		sb.addPoints(2);
		assertEquals(1, sb.getP2Score());
		sb.addPoints(1);
		
		sb.resetScore();
		assertEquals(0, sb.getP1Score());
		assertEquals(0, sb.getP2Score());
		
	}
	
	@Test
	void testBallMovement() {
		Ball ball = new Ball();
		Board board = new Board();
		ball.resetBallPosition(1);
		assertEquals(450, ball.getX());
		assertEquals(450, ball.getY());
		ScoreBoard scoreBoard = new ScoreBoard();
		ball.move(board, scoreBoard);
		assertEquals(447, ball.getX());
		assertEquals(449, ball.getY());
		
	}
	

}
