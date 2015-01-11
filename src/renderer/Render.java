package renderer;

public class Render {
	
	public static int width, height;
	public static int[][] pixels;
	
	private static Triangle tri;
	
	public static void init(int w, int h) {
		width = w;
		height = h;
		pixels = new int[width][height];
		tri = new Triangle();
		tri.vertices[0] = new Vec3(-1, 0, 0);
		tri.vertices[1] = new Vec3( 1, 0, 0);
		tri.vertices[2] = new Vec3( 0, 1, 0);
	}
	
	public static void render() {
		clear(colorToHex(0, 0, 0.4));
		
		renderTri(tri);
	}
	
	private static void renderTri(Triangle t) {
		
	}
	
	public static void renderScanline(int x0, int x1, int y) {
		for (int x = x0; x < x1; x++) {
			pixels[x][y] = 0xFFFFFF;
		}
	}
	
	public static void clear() {
		clear(0);
	}
	
	public static void clear(int color) {
		for (int x = 0; x < pixels.length; x++) {
			for (int y = 0; y < pixels[0].length; y++) {
				pixels[x][y] = color;
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
