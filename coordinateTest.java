/* coordinateTest.java
 * 
 * Test file - consists of the unit tests for the validation of 
 * rover coordinates within the specified plateau grid 
 * 
 * Author: Anum Qudsia
 * Assignment: Mars Rover from ThoughtWorks
 * Date Modified: 29-05-13
 */
import org.junit.*;

import static org.junit.Assert.*;


public class coordinateTest {
	
	Rover RoverObject;
	Plateau PlateauObject;
	
	@Before
	public void setUp() {
		RoverObject = new Rover(2, 5, 'W');
		PlateauObject = new Plateau(5, 5);
	}
	
	@Test 
	// Check that rover is not null when created with data
	public void testRoverIsNotNull() {
		assertNotNull(RoverObject);
	}
	
	@Test
	// Check that plateau is not null when created with data
	public void testPlateauIsNotNull() {
		assertNotNull(PlateauObject);
	}
	
	@Test
	/* Check that X coordinate of the rover is valid within the
	 * x-coordinate limit of the plateau grid
	 */
	public void testXCoordinateIsValid() {
		
		int x = PlateauObject.getX();
		assertTrue(RoverObject.checkXCoordinateIsValid(x));
	}

	@Test
	/* Check that X coordinate of the rover is invalid if found 
	 * outside the x-coordinate of the plateau grid
	 */
	public void testXCoordinateIsInvalid() {
		int x = PlateauObject.getX();
		RoverObject.setX(6);
		assertFalse(RoverObject.checkXCoordinateIsValid(x));
	}
	
	@Test
	/* Check that Y coordinate of the rover is valid within the
	 * y-coordinate limit of the plateau grid
	 */
	public void testYCoordinateIsValid() {
		
		int y = PlateauObject.getY();
		assertTrue(RoverObject.checkYCoordinateIsValid(y));
	}
	
	
	@Test
	/* Check that Y coordinate of the rover is invalid if found 
	 * outside the y-coordinate of the plateau grid
	 */
	public void testYCoordinateIsInvalid() {
		
		int y = PlateauObject.getY();
		RoverObject.setY(-1);
		assertFalse(RoverObject.checkYCoordinateIsValid(y));
	}
	
	@Test
	/* Check that the direction of the rover is valid if the direction
	 * value is either one of these: N, W, S, E 
	 */
	public void testDirectionIsValid() {		
		
		assertTrue(RoverObject.checkDirectionIsValid());
	}	
	
	@Test
	/* Check that the direction of the rover is invalid if the value
	 * for the direction is NOT either one of these: N, W, S, E 
	 */
	public void testDirectionIsInvalid() {
		
		RoverObject.setDirection('K');
		assertFalse(RoverObject.checkDirectionIsValid());
	}
	
	@Test
	// Check the rover's overall validity in the grid 
	public void testRoverIsValid() {
		
		int x = PlateauObject.getX();
		int y = PlateauObject.getY();
		assertTrue(RoverObject.validateRover(x, y));
	}
	
	@Test
	/* Check that invalid values for the rover return a failure
	 * of rover validation
	 */
	public void testRoverIsInvalid() {
		
		int x = PlateauObject.getX();
		int y = PlateauObject.getY();
		RoverObject.setX(-1);
		RoverObject.setY(66);
		RoverObject.setDirection('L');
		assertFalse(RoverObject.validateRover(x, y));
	}
	
	
	@After
	public void tearDown() {
		RoverObject = null;
		PlateauObject = null;
	}

}
