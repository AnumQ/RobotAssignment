/* Rover.java
 * 
 * main - controls the flow of the system
 * 
 * Author: Anum Qudsia
 * Assignment: Mars Rover from ThoughtWorks
 * Date Modified: 29-05-13
 */

import java.util.Scanner;

public class RoverPlan {
	
	public static void main (String args[] ) throws Exception {
		

		Scanner input = new Scanner( System.in ); 
		Rover myRover = new Rover();
		Plateau thisPlateau = new Plateau();
		// set the coordinates for Plateau
		
		thisPlateau.setPlateauCoordinates(input);
		int pX = thisPlateau.getX();
		int pY = thisPlateau.getY();
		
		System.out.println("Plateau: " + pX + " " + pY);
		
		System.out.println("Please enter the Rover data:");
		myRover.setRoverData(input);
		
		
		// validate the Rover's data
		while (!myRover.validateRover(pX, pY))
		{
			System.out.println("Please try again. Enter the Rover data:");
			myRover.setRoverData(input);
		}
		
		//The Rover's current position
		System.out.println("Rover's current position is: " + myRover.getX() + " " + 
		myRover.getY() + " " + myRover.getDirection() );	
		
		input.nextLine();
		System.out.println("Enter the instructions:");
		
		//instructions for the Rover
		String myString = input.nextLine(); 
		input.close();
		
		// Iterate through the instructions
		for( int i = 0; i < myString.length(); i++ ) {
			char current = myString.charAt(i);
			
			// Move the Rover according to the instructions
			myRover.processInstructions(current, pX, pY);
		}		
		// get Rover's final position
		System.out.println("Rover's final position is: " + myRover.getX() + " " + 
		myRover.getY() + " " + myRover.getDirection() );		
			
		System.out.println("Finish!");				
	}
}
