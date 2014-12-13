package renderer;

import user.Main;

public class Render {
	
	public static int width, height;
	public static int[][] pixels;
	
	public static RenderThread[] threads = new RenderThread[4];
	
	public static void init(int w, int h) {
		width = w;
		height = h;
		pixels = new int[width][height];
//		RenderThread.threads = 5;
	}
	
	public static void render() {
		for (int i = 0; i < 250; i++) {
			renderScanline(200 + i, 600 - i, 150 + i);
		}
	}
	
	public static void renderScanline(int x0, int x1, int y) {
		for (int x = x0; x < x1; x++) {
			pixels[x][y] = colorToHex((double) (x - x0) / (x1 - x0), 0, 0);
		}
	}
	
	public static int colorToHex(double r, double g, double b) {
		int rHex = (int) (r * 0xFF);
		int gHex = (int) (g * 0xFF);
		int bHex = (int) (b * 0xFF);
		return rHex << 16 | gHex << 8 | bHex;
	}
	
}
