/**
 * CIS151 Spring 2025 Assignment 4 Solution
 * @author Nam Tan Ngo
 * @version 1.0 04/19/2025
 */
package Shape_Displayer;

import java.awt.Graphics2D;

/**
 * an interface that hold general method of shape objects
 */
public interface CompositeShape {
	public void draw(Graphics2D g2);	// draw the object on g2
	public Factory getFactory();		// create factory interface object
}
