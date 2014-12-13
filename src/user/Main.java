package user;

import javax.swing.JFrame;

import renderer.Display;

public class Main {
	
	public static JFrame window;

	public static void main(String[] args) {
		Display d = new Display();
		
		window = new JFrame("Gitworks");
		window.add(d);
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
