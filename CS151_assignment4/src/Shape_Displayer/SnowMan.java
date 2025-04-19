/**
 * CIS151 Spring 2025 Assignment 4 Solution
 * @author Nam Tan Ngo
 * @version 1.0 04/19/2025
 */
package Shape_Displayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

/**
 * a snow man object that can be draw
 */
public class SnowMan implements CompositeShape {
	private int width;
	private int x;
	private int y;
	
	/**
	 * Constructor
	 * @param w - the width of the snow man
	 * @param xLoc - space to the left
	 * @param yLoc - space to the top
	 */
	public SnowMan(int w, int xLoc, int yLoc) {
		width = w/2;
		x = xLoc;
		y = yLoc;
	}
	
	/**
	 * It will draw an image of a snow man on g2
	 * @param g2 - a graphic context
	 */
	public void draw(Graphics2D g2)
	 {
		Ellipse2D.Double head = new Ellipse2D.Double(x - width/2, y - width, width, width);
		Ellipse2D.Double body = new Ellipse2D.Double(x - width/2, y, width, width);
		Ellipse2D.Double eye_l = new Ellipse2D.Double(x - width/5, y - 3*width/4, width/10, width/10);
		Ellipse2D.Double eye_r = new Ellipse2D.Double(x + width/5, y - 3*width/4, width/10, width/10);
		
		Ellipse2D.Double btn_top = new Ellipse2D.Double(x, y + 1*width/4, width/10, width/10);
		Ellipse2D.Double btn_mid = new Ellipse2D.Double(x, y + 2*width/4, width/10, width/10);
		Ellipse2D.Double btn_bot = new Ellipse2D.Double(x, y + 3*width/4, width/10, width/10);

		Polygon nose = new Polygon();
		nose.addPoint(x - width/6, 	y - 2*width/6);
		nose.addPoint(x, 			y - 3*width/6);
		nose.addPoint(x + width/6, 	y - 2*width/6);
		
		g2.setColor(Color.white);
		g2.fill(head);
		g2.fill(body);

		g2.setColor(Color.orange);
		g2.fill(nose);
		
		g2.setColor(Color.black);
		g2.fill(btn_top);
		g2.fill(btn_mid);		
		g2.fill(btn_bot);
		g2.draw(head);
		g2.draw(body);
		g2.draw(nose);
		g2.draw(eye_l);
		g2.draw(eye_r);
	 }
	
	/**
	 * return a class that with a function to create snow man object
	 * @return Factory - a function to create snow man object
	 */
	@Override
	public Factory getFactory() {		
		return new Factory() {
			public CompositeShape make(int w, int x, int y) {
				return new SnowMan(w,x,y);
			}	
		};
	}
}
