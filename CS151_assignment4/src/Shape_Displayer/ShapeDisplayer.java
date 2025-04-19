/**
 * CIS151 Spring 2025 Assignment 4 Solution
 * @author Nam Tan Ngo
 * @version 1.0 04/19/2025
 */
package Shape_Displayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * The main method which the beginning point to start the program
 */
public class ShapeDisplayer {
	public static void main(String[] args) {

		//set up buttons
		JButton carBtn = new JButton(new ShapeIcon(new CarShape(50,1,10)));
		JButton snowManBtn = new JButton(new ShapeIcon(new SnowMan(50,25,25)));
		JButton tree = new JButton(new ShapeIcon(new Tree(30,25,35)));

		carBtn.setPreferredSize(new Dimension(50,50));
		snowManBtn.setPreferredSize(new Dimension(50,50));
		tree.setPreferredSize(new Dimension(50,50));

		//create menu panel which hold buttons
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new FlowLayout());
		menuPanel.add(carBtn);
		menuPanel.add(snowManBtn);
		menuPanel.add(tree);

		//create draw scene
		SceneShape drawPanel = new SceneShape();
		Border border = BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(71,145,255));
		drawPanel.setBorder(border);
		
		//frame
		JFrame frame = new JFrame();
		frame.setTitle("Shape Displayer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(menuPanel,BorderLayout.NORTH);
		frame.add(drawPanel,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

		//add button listener
		carBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setFactory(new CarShape(0,0,0).getFactory());		
			}});
		
		snowManBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setFactory(new SnowMan(0,0,0).getFactory());
			}});
		
		tree.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawPanel.setFactory(new Tree(0,0,0).getFactory());
			}});
	}	
}
