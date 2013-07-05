/* Plateau.java
 * 
 * Class file - consists of the attributes/methods to create 
 * the plateau grid
 * 
 * 
 * Author: Anum Qudsia
 * Assignment: Mars Rover from ThoughtWorks
 * Date Modified: 29-05-13
 */
import java.util.Scanner;

public class Plateau {
	
	private int x;
	private int y;
	
	public Plateau() {
		
	}
	public Plateau(int xCor, int yCor) {
		setX(xCor);
		setY(yCor);
	}

	public void setX(int xCoordinate) {
		x = xCoordinate;		
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int yCoordinate) {
		y = yCoordinate;
	}
	
	public int getY() {
		return y;
	}
	
	/* This function is called from main - sets the Plateau coordinates from 
	 * the user input
	 */
	public void setPlateauCoordinates(Scanner input) {
		
		System.out.println( "Please enter the plateu coordinates:" );
		boolean flag = true;
		while (flag) {
			try {
				x = input.nextInt();
				y = input.nextInt();
				flag = false;
			} 
			catch(java.util.InputMismatchException e) {
				input.nextLine();
		        System.out.println("The plateu coordinates are not correct!");
		        System.out.println( "Please enter the plateu coordinates:" );        
			}
			catch(java.util.NoSuchElementException h) {
				input.nextLine();
		        System.out.println("The plateu coordinates are not correct!");
		        System.out.println( "Please enter the plateu coordinates:" );
			}
		}
		setX(x);
		setY(y);
	}

}
