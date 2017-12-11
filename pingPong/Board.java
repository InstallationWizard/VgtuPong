package pingPong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/***
 * 
 * 
 * @author lukas
 *
 */

public class Board extends JPanel implements KeyListener, Runnable{

	
	Thread thread;
	
	PlayerPaddle leftPaddle;
	PlayerPaddle rightPaddle;
	
	Ball ball;
	
	MiddleLine middleLine;
	
	ScoreBoard scoreBoard;
	
	boolean paused = true;
	
	public static int height, width;
	
	Board(){
		initBoard();
	}
	
	private void initBoard() {
		
		Dimension size = this.getSize();
		
		height = size.height;
		width = size.width;
		
		thread = new Thread(this);
		thread.start();
		
		leftPaddle = new PlayerPaddle(1, this);
		rightPaddle = new PlayerPaddle(2, this);
		
		middleLine = new MiddleLine();
		middleLine.setBoard(this);
		
		scoreBoard = new ScoreBoard();
		
		ball  = new Ball(this);
		
		this.addKeyListener(this);
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		middleLine.paintComponent(g);
		leftPaddle.paintComponent(g);
		rightPaddle.paintComponent(g);
		ball.paintComponent(g);
		scoreBoard.paintComponent(g,this);
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rightPaddle.setUpAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			rightPaddle.setDownAccel(true);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			leftPaddle.setUpAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_S){
			leftPaddle.setDownAccel(true);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rightPaddle.setUpAccel(false);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			rightPaddle.setDownAccel(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			leftPaddle.setUpAccel(false);
		}
		else if (e.getKeyCode() == KeyEvent.VK_S){
			leftPaddle.setDownAccel(false);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_P) {
			paused=!paused;
		}
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void run() {
		for(;;) {
			
			if(!paused) {
				moveGameObjects();
			
				if(ball != null)
					ball.checkCollision(leftPaddle, rightPaddle, this);
			
				repaint();
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}



	private void moveGameObjects() {
		if(leftPaddle != null)
			leftPaddle.move(this);

		if(rightPaddle != null)
			rightPaddle.move(this);

		if(ball != null)
			ball.move(this, scoreBoard);
	}


	
	
	
}


