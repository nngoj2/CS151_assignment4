/**
 * CIS151 Spring 2025 Assignment 4 Solution
 * @author Nam Tan Ngo
 * @version 1.0 04/19/2025
 */
package Shape_Displayer;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * a class that hold the icon to be paint in button
 */
public class ShapeIcon implements Icon {
	private int width;
	private int height;
	private CompositeShape shape;
	
	/**
	 * Constructor
	 * @param s - a CompositeShape
	 */
	public ShapeIcon(CompositeShape s) { shape =s;}
	
	/**
	 * override paintIcon method of Icon interface
	 * draw the image of the shape in ShapeIcon
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
			Graphics2D g2 = (Graphics2D) g;
			shape.draw(g2);	
	}
	
	/**
	 * get the  width 
	 */
	@Override
	public int getIconWidth() {return width;}
	
	/**
	 * get the height
	 */
	@Override
	public int getIconHeight() {return height;}
}
