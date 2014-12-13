package renderer;

public class Render {
	
	public static int width, height;
	public static int[][] pixels;
	
	public static void render() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				pixels[x][y] = colorToHex(x / width, x / width, x / width);
			}
		}
	}
	
	public static int colorToHex(double r, double g, double b) {
		int rHex = (int) (r * 0xFF);
		int gHex = (int) (g * 0xFF);
		int bHex = (int) (b * 0xFF);
		return rHex << 16 | gHex << 8 | bHex;
	}
	
}
