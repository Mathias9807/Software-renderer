package renderer;

import java.awt.*;
import java.awt.image.*;

public class Display extends Canvas {
	private static final long serialVersionUID = 1L;
	
	public BufferedImage 	img;
	public int[] 			pixels;

	public Display() {
		img 	= new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels 	= ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		Render.width = WIDTH;
		Render.height = HEIGHT;
		Render.pixels = new int[WIDTH][HEIGHT];
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Render.render();
		
		for (int x = 0; x < WIDTH; x++){
			for (int y = 0; y < HEIGHT; y++){
				pixels[x + y * WIDTH] = Render.pixels[x][y];
			}
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
}
