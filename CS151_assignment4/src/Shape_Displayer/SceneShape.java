/**
 * CIS151 Spring 2025 Assignment 4 Solution
 * @author Nam Tan Ngo
 * @version 1.0 04/19/2025
 */
package Shape_Displayer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JComponent;

/**
 * the draw panel with user-defined function and local memory
 */
public class SceneShape extends JComponent {
	private LinkedList<CompositeShape> shapes;
	private Factory factory;
	
	/**
	 * constructor with default MouseListener
	 */
	public SceneShape() {
		shapes = new LinkedList<CompositeShape>();
		addMouseListener(new MouseListeners());
		setPreferredSize(new Dimension(500,500));
	}
	
	/**
	 * paint all the shape in local memory
	 * @param g - a graphic context like paper to be draw on
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(CompositeShape shape: shapes) {
			shape.draw(g2);
		}
	}

	/**
	 * set the Factory 
	 * @param f - Factory data type
	 */
	public void setFactory(Factory f) {factory =f;}
	
	/**
	 * set default MouseListeners
	 */
	private class MouseListeners extends MouseAdapter{
		public void mousePressed(MouseEvent event) {
			try {
				Point point = event.getPoint();
				int x = (int) point.getX();
				int y = (int) point.getY();
				shapes.add(factory.make(100, x, y));
				repaint();
			}catch(Exception e) {System.out.println("none factory was added");}	
		}
	}
}
