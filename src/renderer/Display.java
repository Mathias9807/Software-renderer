package renderer;

import java.awt.*;
import java.awt.image.*;

public class Display extends Canvas {
	private static final long serialVersionUID = 1L;
	
	public int width, height;
	public BufferedImage 	img;
	public int[] 			pixels;

	public Display(int w, int h) {
		width = w;
		height = h;
		img 	= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels 	= ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		Render.init(width, height);
	}
	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Render.render();
		
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				pixels[x + y * width] = Render.pixels[x][y];
			}
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
}
