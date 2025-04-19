/**
 * CIS151 Spring 2025 Assignment 4 Solution
 * @author Nam Tan Ngo
 * @version 1.0 04/19/2025
 */
package Shape_Displayer;

/**
 * create another way to generate object with polymorphism
 */
public interface Factory {
	public CompositeShape make(int w, int x, int y); 	// simply call constructor of the object
}
