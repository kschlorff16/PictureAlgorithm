import java.awt.Color;
import java.util.ArrayList;



// A fun wrapper class to contain specific colors and their respective frequencies. 


public class ColorandCoords implements Comparable<ColorandCoords> {
	private ArrayList<Integer> Xcoords = new ArrayList<Integer>();
	private ArrayList<Integer> Ycoords = new ArrayList<Integer>();
	private Color color;
	private String hexTitle;
	private int frequency = 0;


	public ColorandCoords(int x, int y, Color newcolor) {
		this.Xcoords.add(x);
		this.Ycoords.add(y);
		this.color = newcolor;
		this.hexTitle = convertColor(newcolor);
		frequency++;
	}
	
	public static String convertColor(Color color) {
		
			int r = color.getRed();
			int g = color.getGreen();
			int b = color.getBlue();
			
			String hex = String.format("%02x%02x%02x",r, g, b);
			return hex;
		
		
	
		
		
	
	}
	


	public void add(int x, int y) {
		this.Xcoords.add(x);
		this.Ycoords.add(y);
		frequency++;
	}

	
	public int getX(int x) {
		return Xcoords.get(x);
	}
	
	public int getY(int y) {
		return Ycoords.get(y);
	}



	public int getFrequency() {
		return this.frequency;
	}

	public Color getColor() {
		Color returnColor = this.color;
		return returnColor;
	}


	@Override
	public int compareTo(ColorandCoords other) {
		int otherFrequency = other.getFrequency();
		return Integer.compare(this.frequency, otherFrequency);
	}
}

