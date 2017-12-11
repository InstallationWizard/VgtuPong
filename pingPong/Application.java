package pingPong;

import javax.swing.JFrame;


public class Application extends JFrame{
	
	
	public Application(){
		
		InitUI();
	}
	
	private void InitUI() {
		
		add(new Board());
		setSize(960,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
		
	}

	public static void main(String[] args) {
		
		Application ex = new Application();
		ex.setVisible(true);
		
	}
		
	
}
