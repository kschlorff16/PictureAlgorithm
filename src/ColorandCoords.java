/** A fun wrapper class to contain specific colors and their respective frequencies.
 *  
 *  @author KentSchlorff
 * 
 * */
 

import java.awt.Color;
import java.util.ArrayList;



 


public class ColorandCoords implements Comparable<ColorandCoords> {
	private ArrayList<Integer> Xcoords = new ArrayList<Integer>();
	private ArrayList<Integer> Ycoords = new ArrayList<Integer>();
	private Color color;
	private int frequency = 0;


	/**
	 * Here's the constructor. There is only one.
	 * @param x The x coordinate of the pixel.
	 * @param y The y coordinate of the pixel.
	 * @param newcolor The color of the pixel.
	 */
	public ColorandCoords(int x, int y, Color newcolor) {
		this.Xcoords.add(x);
		this.Ycoords.add(y);
		this.color = newcolor;
		frequency++;
	}
	
	/**
	 * I wrote my own method to convert Colors to Hex Strings. There is a method written into Java, but I wrote this first, and I'm stubborn.
	 * @param color The color to convert.
	 * @return A String representation of the color in hexadecimal RGB format.
	 */
	public static String convertColor(Color color) {
		
			int r = color.getRed();
			int g = color.getGreen();
			int b = color.getBlue();
			
			String hex = String.format("%02x%02x%02x",r, g, b);
			return hex;
		
		
	
		
		
	
	}
	

/**
 * This method adds a new location of a particular color.
 * @param x The x coordinate of the pixel.
 * @param y The y coordinate of the pixel.
 */
	public void add(int x, int y) {
		this.Xcoords.add(x);
		this.Ycoords.add(y);
		frequency++;
	}

	/**
	 * A get method for x coordinates.
	 * @param x The index of the x coordinate within the ArrayList.
	 * @return The xth index in Xcoords.
	 */
	public int getX(int x) {
		return Xcoords.get(x);
	}
	
	/**
	 * A get method for y coordinates.
	 * @param y The index of the y coordinate within the ArrayList.
	 * @return The yth index in Ycoords.
	 */
	public int getY(int y) {
		return Ycoords.get(y);
	}


/**
 * A method to return the frequency of a given color. Useful for debugging and displaying more information if we wanted to do that.
 * @return The frequency of the specific color.
 */
	public int getFrequency() {
		return this.frequency;
	}

	
	/**
	 * A method to return the color of a given ColorandCoords object.
	 * @return The color of the object.
	 */
	public Color getColor() {
		Color returnColor = this.color;
		return returnColor;
	}


	/**
	 * Because Comparable has to implement compareTo, I just had it compare the frequencies. Works great!
	 */
	@Override
	public int compareTo(ColorandCoords other) {
		int otherFrequency = other.getFrequency();
		return Integer.compare(this.frequency, otherFrequency);
	}
}

