import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class PictureAlgorithm {
	public static void main(String[] args) {
		Picture pic = new Picture(args[0]);
		int width  = pic.width();
		int height = pic.height();
		
		

//		Color[] colors = new Color[width * height];
		Color colors = new Color(0, 0, 0);
		HashSet<Color> uniqueColors = new HashSet<Color>();
//		ArrayList<Color> uniqueList = new ArrayList<Color>();
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
					for (int xx = 0; xx < colorandcoords.size(); xx++) {
						if (colorandcoords.get(xx).getColor() == colors) {
							colorandcoords.get(xx).add(x, y);
						}
					}
				}
//				
			}
			j++;
		}
		Collections.sort(colorandcoords);
		
		System.out.println("There are " + uniqueColors.size() + " unique colors in the picture.");
		
		
//		int zz = 0;
//		for (int x = 0; x < width; x++){
//			for (int y = 0; y < height; y++) {
//				colorandcoords[0].add(x, y); 
//				the reason the above line will be weird is because every single 
//				element of colorandcoords will be an object
//			}
//			
//		}
//		
		
		
		
//		for ()
		
		
//		int k = 0;
//		StdDraw.clear();
//		StdDraw.setXscale(0, width);
//		StdDraw.setYscale(0, height);
//		
//
////		for (int i = 0; i < uniqueColors.size(); i++) {
//			for (int i = 0; i < colorandcoords.get(i).getFrequency(); i++) {
//				
//				StdDraw.setPenColor(colorandcoords.get(k).getColor());
//				StdDraw.point(colorandcoords.get(i).getX(i), colorandcoords.get(i).getY(i)/2);
//				k++;
//				
//			}

		}
	}

