/**
 * CIS151 Spring 2025 Assignment 4 Solution
 * @author Nam Tan Ngo
 * @version 1.0 04/19/2025
 */
package Shape_Displayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

/**
 * a tree object that can be draw
 */
public class Tree implements CompositeShape {
	private int width;
	private int x;
	private int y;
	
	/**
	 * Constructor
	 * @param w - the width of the tree
	 * @param xLoc - space to the left
	 * @param yLoc - space to the top
	 */
	public Tree(int w, int xLoc, int yLoc) {
		width = w;
		x = xLoc;
		y = yLoc;
	}
	
	/**
	 * It will draw an image of a tree on g2
	 * @param g2 - a graphic context
	 */
	public void draw(Graphics2D g2)
	 {
		Polygon triangle_bot = new Polygon();
		triangle_bot.addPoint(x - width/3, 	y - 0*width/6);
		triangle_bot.addPoint(x, 			y - 3*width/6);
		triangle_bot.addPoint(x + width/3, 	y - 0*width/6);
		
		Polygon triangle_mid = new Polygon();
		triangle_mid.addPoint(x - width/3, 	y - 2*width/6);
		triangle_mid.addPoint(x, 			y - 5*width/6);
		triangle_mid.addPoint(x + width/3, 	y - 2*width/6);
		
		Polygon triangle_top = new Polygon();
		triangle_top.addPoint(x - width/3, 	y - 4*width/6);
		triangle_top.addPoint(x, 			y - 7*width/6);
		triangle_top.addPoint(x + width/3, 	y - 4*width/6);

		Rectangle2D.Double body = new Rectangle2D.Double(x - width/10, y, width/5, width/2);

		g2.setColor(Color.black);
		g2.draw(triangle_bot);
		g2.draw(triangle_mid);
		g2.draw(triangle_top);
		g2.draw(body);
		
		g2.setColor(Color.green);
		g2.fill(triangle_bot);
		g2.fill(triangle_mid);
		g2.fill(triangle_top);
		
		g2.setColor(new Color(120, 70, 20)); //brown
		g2.fill(body);

	 }
	
	/**
	 * return a class that with a function to create Tree object
	 * @return Factory - a function to create Tree object
	 */
	@Override
	public Factory getFactory() {		
		return new Factory() {
			public CompositeShape make(int w, int x, int y) {
				return new Tree(w,x,y);
			}	
		};
	}
}
