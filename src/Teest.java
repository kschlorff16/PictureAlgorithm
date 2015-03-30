import java.awt.Color;


public class Teest {



	private static String convertColor(Color color) {

		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();

		String hex = String.format("%02x%02x%02x",r, g, b);
		return hex;


		



	}
	
	
	
	
	public static void main(String[] args) {
		Color color = new Color(0, 51, 250);
		System.out.println(convertColor(color));
		System.out.println(Integer.toHexString(color.getRGB()));
		
		
	}
}
