/** PictureMagic takes in a picture as an argument, and recreates that picture using the most common color first.
 * @author Kent Schlorff
 * 
 */




import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class PictureMagic {
	public static void main(String[] args) {
		Picture pic = new Picture(args[0]);
		int width  = pic.width();
		int height = pic.height();
		
		

		Color colors = new Color(0, 0, 0);
		HashSet<Color> uniqueColors = new HashSet<Color>();
		BinarySearchST<String, Integer> ST = new BinarySearchST<String, Integer>();
		ArrayList<ColorandCoords> colorandcoords = new ArrayList<ColorandCoords>();
		int j = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				colors = pic.get(x, y);
				if (!(uniqueColors.contains(colors))) {
					uniqueColors.add(colors);
					colorandcoords.add(new ColorandCoords(x, y, colors));
					ST.put(ColorandCoords.convertColor(colors), j);
					j++;
				}
				else {
					int k = ST.get(ColorandCoords.convertColor(colors));
							colorandcoords.get(k).add(x, y);
							
						
					
				}
			}

		}
		Collections.sort(colorandcoords);
//		System.out.println("The first color has this many colors: " + colorandcoords.get(0).getFrequency());
//		System.out.println("The second color has this many colors: " + colorandcoords.get(1).getFrequency());
//		System.out.println("The last color has this many colors: " + colorandcoords.get(colorandcoords.size()-1).getFrequency());
//		System.out.println("The second to last color has this many colors: " + colorandcoords.get(colorandcoords.size()-2).getFrequency());
		System.out.println("There are " + uniqueColors.size() + " unique colors in the picture.");
			
		
		
		StdDraw.clear();
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);


		for (int z = colorandcoords.size()-1; z >= 0; z--) {
			for (int i = 0; i < colorandcoords.get(z).getFrequency(); i++) {

				StdDraw.setPenColor(colorandcoords.get(z).getColor());
				StdDraw.point(colorandcoords.get(z).getX(i), height - (colorandcoords.get(z).getY(i)));
			}
		}

	}
}