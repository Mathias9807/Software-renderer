package user;

import javax.swing.JFrame;

import renderer.Display;

public class Main {
	
	public static final boolean FRAMERATE_LOCK 	= false;
	public static final int 	FRAMERATE 		= 30;
	
	public static JFrame window;
	public static Display d;
	
	public static boolean running = true;

	public static void main(String[] args) {
		window = new JFrame("Display");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		d = new Display(window.getWidth(), window.getHeight());
		window.add(d);
		
		window.setVisible(true);
		
		loop();
		
		destroy();
		
		System.exit(0);
	}
	
	public static void loop() {
		long now = System.nanoTime();
		long past = System.nanoTime();
		double nano = 1000000000;
		double fpsTimer = 0;
		int fps = 0;
		while (running) {
			now = System.nanoTime();
			double delta = (double) (now - past) / nano;
			double waitTime = 1d / FRAMERATE - delta;
			if (waitTime < 0) waitTime = 0;
			if (FRAMERATE_LOCK) {
				try {
					Thread.sleep((long) (waitTime * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			fps++;
			fpsTimer += delta;
			if (fpsTimer > 1) {
				System.out.println("Frames per second: " + fps);
				fpsTimer = 0;
				fps = 0;
			}
			d.render();
			past = now;
		}
	}
	
	public static void destroy() {
	}

}
