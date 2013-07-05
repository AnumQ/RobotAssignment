/* Rover.java
 * 
 * Class file - consists of the attributes/methods to create rover
 * and manipulate its data and location 
 * 
 * Author: Anum Qudsia
 * Assignment: Mars Rover from ThoughtWorks
 * Date Modified: 29-05-13
 */

import java.util.Scanner;

public class Rover {
	
	private int positionX;
	private int positionY;
	private char direction;
	
	public Rover() { 
	}
	
	public Rover(int x, int y, char d) {
		setX(x);
		setY(y);
		setDirection(d);
	}

	public void setX(int x) {
		positionX = x;
	}

	public int getX() {
		return positionX;		
	}
	
	public void setY(int y) {
		positionY = y; 
	}
	
	public int getY() {
		return positionY;
	}
	
	public void setDirection(char d) {
		direction = d;
	}
	
	public char getDirection() {
		return direction;
	}

	/*	Checks the validity of X coordinate of the Rover against the 
	 *	maximum X-axe value in the plateau grid
	 */
	public boolean checkXCoordinateIsValid(int max) {
		
		int posX = getX();
		return checkCoordinateValue(posX, max);
	}

	/*	Checks the validity of Y coordinate of the Rover against the 
	 *	maximum Y-axe value in the plateau grid
	 */
	public boolean checkYCoordinateIsValid(int max) {
		int posY = getY();
		return checkCoordinateValue(posY, max);
	}
	
	// Sub function - checks the validity of the Rover coordinates
	private boolean checkCoordinateValue(int pos, int max) {
		if (pos >= 0 && pos <= max ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Validates the Rover direction
	public boolean checkDirectionIsValid() {
		
		char d = getDirection();
		if ( d == 'N' || d == 'S' || d == 'W' || d == 'E')
		{
			return true;
		}
		else {
			return false; 
		}
	}
	
	// Validates the Rover data against the coordinates of the plateau
	public boolean validateRover(int plateauX, int plateauY) {
		if (!checkXCoordinateIsValid(plateauX)) {
			System.out.println("Invalid X coordinate");
			return false;
		}
			
		if (!checkYCoordinateIsValid(plateauY)) {
			System.out.println("Invalid Y coordinate");
			return false;
		}
			
		if (!checkDirectionIsValid()) {
			System.out.println("Invalid Direction");
			return false;
		}			
		return true;
	}
	
	//Checks that Rover move along x-axe is valid
	public boolean checkMoveXIsValid(int value, int plateauX) {
		return validatePosition(value, plateauX);		
	}
	
	//Checks that Rover move along y-axe is valid
	public boolean checkMoveYIsValid(int value, int plateauY) {
		return validatePosition(value, plateauY);		
	}
	
	//Sub function - Checks that Rover move is valid
	private boolean validatePosition(int value, int max) {
		if ( value >= 0 && value <= max ) {
			return true;
		}
		else {
			System.out.println("Move is not valid\n");
			return false;
		}
	}
	
	//Move Rover 1 step to the left
	public void moveWest() {
		int x = getX();
		setX(x-1);
	}
	
	//Move Rover 1 step to the right
	public void moveEast() {		
		int x = getX();
		setX(x+1);		
	}
	
	//Move Rover 1 step up the grid
	public void moveNorth() {
		int y = getY();
		setY(y+1);	
	}
	
	//Move Rover 1 step down the grid
	public void moveSouth() {
		
		int y = getY();
		setY(y-1);
	}
	
	//Change the Rover direction - 90 degrees right
	public void turnRight() {
		
		char d = getDirection();
		
		switch(d) {
			case 'N': setDirection('E');
				break;
			case 'E': setDirection('S');
				break;
			case 'S': setDirection('W');
				break;
			case 'W': setDirection('N');
				break;
			default: System.out.println("Invalid currentDirection");
				break;
		}		
	}

	//Change the Rover direction - 90 degrees left
	public void turnLeft() {

		char d = getDirection();
		
		switch(d) {
			case 'N': setDirection('W');
				break;
			case 'W': setDirection('S');
				break;
			case 'S': setDirection('E');
				break;
			case 'E': setDirection('N');
				break;
			default: System.out.println("Invalid currentDirection");
				break;
		}		
	}
	
	/* Moves the Rover validating each move to be within the boundaries of the
	 * plateau grid
	 */	
	public void moveRover(int plateauX, int plateauY) {
		
		char d = getDirection();
		
		switch(d) 
		{
		case 'N': moveNorth();
				  if (!checkMoveYIsValid(getY(), plateauY))
				  {
					System.out.println("Exiting..");
			  		System.exit(-1);
				  }
				  break;
		case 'E': moveEast();
				  if (!checkMoveXIsValid(getX(), plateauX))
				  {
					System.out.println("Exiting..");
			  		System.exit(-1);
				  }
		          break;
		case 'S': moveSouth();
				  if (!checkMoveYIsValid(getY(), plateauY))
				  {
					System.out.println("Exiting..");
					System.exit(-1);
				  }
				  break;
		case 'W': moveWest();
				  if (!checkMoveXIsValid(getX(), plateauX))
				  {
					System.out.println("Exiting..");
					System.exit(-1);
				  }
				  break;
		default: System.out.println("Invalid direction");
				break;
		}
	}
	
	/* This function is called from the main - used to process the instructions
	 * to move the Rover
	 */
	public void processInstructions(char current, int plateauX, int plateauY) {
		
		if ( current == 'L' || current == 'R' || current == 'M') {
			
			if ( current == 'L')
			{
				turnLeft();				
			}
			
			if ( current == 'R')
			{
				turnRight();
			}
			
			if ( current == 'M')
			{				
				moveRover(plateauX, plateauY);						
			}
		}
			
		else {
			System.out.println("Invalid instruction " + current + ". Ignoring..\n");
		}
	}
	
	// Function is called from main - sets the Rover data from the user input 
	public void setRoverData(Scanner input) {
		
		input.nextLine();
		int coordinate1 = 0;
		int coordinate2 = 0;
		char direction = 0;
		
		boolean flag = true;
		
		while (flag) {
			try {
				coordinate1 = input.nextInt();
				coordinate2 = input.nextInt();
				direction = input.next().charAt(0);
				flag = false;
			} 
			catch(java.util.InputMismatchException e) {
				input.nextLine();
		        System.out.println("The rover data is in incorrect format. Please try again.");
		        System.out.println("Enter Rover data:");
			}
		}
			
		setX(coordinate1);
		setY(coordinate2);
		setDirection(direction);		
	}
}
