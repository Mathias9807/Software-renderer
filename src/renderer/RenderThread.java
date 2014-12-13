package renderer;

public class RenderThread extends Thread {
	
	public static int threads;
	public int num;
	
	public void start() {
		//int section = 250 / threads;
		/*for (int i = num * section; i < (num + 1) * section; i++) {
			Render.renderScanline(200 + i, 600 - i, i + 150);
		}*/
		
		int section = Render.width / threads;
		for (int x = num * section; x < (num + 1) * section; x++) {
			for (int y = 0; y < Render.height; y++) {
				Render.pixels[x][y] = 0xFF0000;
			}
		}
	}
	
}
