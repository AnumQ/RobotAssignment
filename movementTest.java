/* movementTest.java
 * 
 * Test file - consists of the unit tests to validate the movement of 
 * rover within the plateau grid 
 * 
 * Author: Anum Qudsia
 * Assignment: Mars Rover from ThoughtWorks
 * Date Modified: 29-05-13
 */
import org.junit.*;

import static org.junit.Assert.*;

public class movementTest {

	Rover RoverObjectGoingWest;
	Rover RoverObjectGoingEast;
	Rover RoverObjectGoingNorth;
	Rover RoverObjectGoingSouth;
	Plateau PlateauObject;
	
	@Before
	public void setUp() {
		
		RoverObjectGoingWest = new Rover(0, 0, 'W');
		RoverObjectGoingEast = new Rover(5, 0, 'E');
		RoverObjectGoingNorth = new Rover(0, 5, 'N' );
		RoverObjectGoingSouth = new Rover(0, 0, 'S' );
		PlateauObject = new Plateau(5, 5);
	}

	@Test 
	/* Test the logical correctness of a rover moving west.
	 * Rover should only move one step left on the plateau grid. 
	 */
	public void testMoveWestIsCorrect() {
		
		RoverObjectGoingWest.moveWest();
		assertEquals(-1, RoverObjectGoingWest.getX());
	}
	
	@Test
	/* Test the rover moving west is fit for business.
	 * Rover should not exceed the limits of the plateau. 
	 */
	public void testMoveWestIsInvalid() {
		RoverObjectGoingWest.moveWest();
		
		int positionX = RoverObjectGoingWest.getX(); // (-1, 0, 'W')
		
		int x = PlateauObject.getX();
		
		assertFalse(RoverObjectGoingWest.checkMoveXIsValid(positionX, x));
	}	
	
	@Test 
	/* Test the logical correctness of a rover moving east.
	 * Rover should only move one step right on the plateau grid. 
	 */
	public void testMoveEastIsCorrect() {
		
		RoverObjectGoingEast.moveEast();
		assertEquals(6, RoverObjectGoingEast.getX());
	}
	
	@Test
	/* Test the rover moving east is fit for business.
	 * Rover should not exceed the limits of the plateau. 
	 */
	public void testMoveEastIsInvalid() {
		RoverObjectGoingEast.moveEast();
		
		int positionX = RoverObjectGoingEast.getX(); // (6, 0, 'E')
		int x = PlateauObject.getX();
		
		assertFalse(RoverObjectGoingEast.checkMoveXIsValid(positionX, x));
	}
	
	/* Ensure that RoverObjectGoingWest's (a rover moving along the
	 * x-axe) position is valid for each move within the plateau grid 
	 */	
	@Test
	public void testMoveXIsValid() {
		RoverObjectGoingWest.moveEast(); // position is (1,0)
		RoverObjectGoingWest.moveEast(); // position is (2,0)
		RoverObjectGoingWest.moveEast(); // position is (3,0)
		RoverObjectGoingWest.moveEast(); // position is (4,0)
		RoverObjectGoingWest.moveEast(); // position is (5,0)
		
		int positionX = RoverObjectGoingWest.getX();
		int x = PlateauObject.getX();
		
		assertTrue(RoverObjectGoingWest.checkMoveXIsValid(positionX, x));
	}
	
	@Test
	/* Ensure that RoverObjectGoingWest's position is NOT valid
	/* for a move outside the plateau grid 
	 */	
	public void testMoveXIsInvalid() {
		RoverObjectGoingWest.moveEast(); // position is (1,0)
		RoverObjectGoingWest.moveEast(); // position is (2,0)
		RoverObjectGoingWest.moveEast(); // position is (3,0)
		RoverObjectGoingWest.moveEast(); // position is (4,0)
		RoverObjectGoingWest.moveEast(); // position is (5,0)
		RoverObjectGoingWest.moveEast(); // position is (6,0)
		
		int positionX = RoverObjectGoingWest.getX();
		int x = PlateauObject.getX();
		
		assertFalse(RoverObjectGoingWest.checkMoveXIsValid(positionX, x));
	}
	
	@Test
	/* Test the logical correctness of a rover moving north.
	 * Rover should only move one step up on the plateau grid. 
	 */
	public void testMoveNorthIsCorrect() {
		
		RoverObjectGoingNorth.moveNorth();
		assertEquals(6, RoverObjectGoingNorth.getY());
		
	}
	
	@Test 
	/* Test the rover moving north is fit for business.
	 * Rover should not exceed the limits of the plateau. 
	 */
	public void testMoveNorthIsInvalid() {
		RoverObjectGoingNorth.moveNorth();
		
		int positionY = RoverObjectGoingNorth.getY(); // (0, 5, 'N' );
		int y = PlateauObject.getY();
		
		assertFalse(RoverObjectGoingNorth.checkMoveYIsValid(positionY, y));
	}	
	
	@Test 
	/* Test the logical correctness of a rover moving south.
	 * Rover should only move one step down on the plateau grid. 
	 */
	public void testMoveSouthIsCorrect() {
		
		RoverObjectGoingSouth.moveSouth();
		assertEquals(-1, RoverObjectGoingSouth.getY());
	}
	
	@Test
	/* Test the rover moving south is fit for business.
	 * Rover should not exceed the limits of the plateau. 
	 */
	public void testMoveSouthIsInvalid() {
		
		RoverObjectGoingSouth.moveSouth(); 
		
		int positionY = RoverObjectGoingSouth.getY(); // (0, -1, 'S' );
		int y = PlateauObject.getY();
		
		assertFalse(RoverObjectGoingSouth.checkMoveYIsValid(positionY, y));
	}
	
	@Test
	/* Ensure that RoverObjectGoingSouth's (rover moving along the 
	 * y-axe) position is valid for each move within the plateau grid 
	 */	
	public void testMoveYIsValid() {
		RoverObjectGoingSouth.moveNorth(); // position is (0,1)
		RoverObjectGoingSouth.moveNorth(); // position is (0,2)
		RoverObjectGoingSouth.moveNorth(); // position is (0,3)
		RoverObjectGoingSouth.moveNorth(); // position is (0,4)
		RoverObjectGoingSouth.moveNorth(); // position is (0,5)
		
		int positionY = RoverObjectGoingSouth.getY(); // (0,5)
		int y = PlateauObject.getY();
		
		assertTrue(RoverObjectGoingSouth.checkMoveYIsValid(positionY, y));
	}
	
	@Test
	/* Ensure that RoverObjectGoingSouths's position is NOT valid
	/* for a move outside the plateau grid 
	 */	
	public void testMoveYIsInvalid() {
		RoverObjectGoingSouth.moveNorth(); // position is (0,1)
		RoverObjectGoingSouth.moveNorth(); // position is (0,2)
		RoverObjectGoingSouth.moveNorth(); // position is (0,3)
		RoverObjectGoingSouth.moveNorth(); // position is (0,4)
		RoverObjectGoingSouth.moveNorth(); // position is (0,5)
		RoverObjectGoingSouth.moveNorth(); // position is (0,6)
		
		int positionY = RoverObjectGoingSouth.getY(); // (0,6)
		int y = PlateauObject.getY();
		
		assertFalse(RoverObjectGoingSouth.checkMoveYIsValid(positionY, y));
	}
	
	@After
	public void tearDown() {
		RoverObjectGoingWest = null;
		RoverObjectGoingEast = null;
		RoverObjectGoingNorth = null;
		RoverObjectGoingSouth = null;
		PlateauObject = null;
	}

}
