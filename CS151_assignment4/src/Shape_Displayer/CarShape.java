/**
 * CIS151 Spring 2025 Assignment 4 Solution
 * @author Nam Tan Ngo
 * @version 1.0 04/19/2025
 */
package Shape_Displayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *a a car shape object that can be draw
 */
public class CarShape implements CompositeShape {
	private int width;
	private int x;
	private int y;
	
	/**
	 * Constructor
	 * @param w - the width of the car
	 * @param xLoc - space to the left
	 * @param yLoc - space to the top
	 */
	public CarShape(int w, int xLoc, int yLoc) {
		width = w;
		x = xLoc;
		y = yLoc;
	}
	
	/**
	 * The code is from Object-Oriented Design and Patterns
	 *Chapter 4: Interfaces and Polymorphism page 26
	 */
	/**
	 * It will draw an image of a car on g2
	 * @param g2 - a graphic context
	 */
	@Override
	public void draw(Graphics2D g2)
	 {
		// Create the parts of this car and draw them here.
		Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6, width - 1, width / 6);
		Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / 6, y + width / 3, width / 6, width / 6);
		Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3, width / 6, width / 6);
		
		 // The bottom of the front windshield
		 Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);
		 // The front of the roof
		 Point2D.Double r2 = new Point2D.Double(x + width / 3, y);
		 // The rear of the roof
		 Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);
		 // The bottom of the rear windshield
		 Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
		
		 Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
		 Line2D.Double roofTop = new Line2D.Double(r2, r3);
		 Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
		
		 g2.setColor(Color.black);
		 g2.fill(frontTire);
		 g2.fill(rearTire);
		 g2.setColor(Color.red);
		 g2.fill(body);
		 g2.draw(frontWindshield);
		 g2.draw(roofTop);
		 g2.draw(rearWindshield);
	 }
	
	/**
	 * return a class that with a function to create car shape object
	 * @return Factory - a function to create car shape object
	 */
	@Override
	public Factory getFactory() {		
		return new Factory() {
			public CompositeShape make(int w, int x, int y) {
				return new CarShape(w,x -50 ,y -20);
			}	
		};
	}
}
