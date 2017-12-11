package pingPong;

public class PlayerPaddle extends Paddle {

	private boolean upAccel, downAccel;
	private double yVelocity;

	public void setUpAccel(boolean input) {
		upAccel = input;
	}

	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	public PlayerPaddle(int player, Board board) {
		y = 450;
		if (player == 1) {
			x = 20;
		} else {
			// x = board.getWidth() ;
			x = 920;
		}
		upAccel = false;
		downAccel = false;
	}

	public void move(Board board) {

		if (upAccel) {
			yVelocity -= 2;
		} else if (downAccel) {
			yVelocity += 2;
		} else if (!upAccel && !downAccel) {
			yVelocity = 0;
		}

		if (yVelocity > 6)
			yVelocity = 6;
		if (yVelocity < -6)
			yVelocity = -6;

		if (y > board.getHeight() - 100)
			y = board.getHeight() - 100;
		if (y < 0)
			y = 0;

		y += yVelocity;
	}

}
