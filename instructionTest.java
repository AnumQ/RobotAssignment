/* instructionTest.java
 * 
 * Test file - consists the unit tests to check that Rover is correctly
 * responding to the instructions
 * 
 * Author: Anum Qudsia
 * Assignment: Mars Rover from ThoughtWorks
 * Date Modified: 29-05-13
 */
import org.junit.*;

import static org.junit.Assert.*;

public class instructionTest {
	
	Rover RoverObjectOnMove;
	
	@Before
	public void setUp() {
		RoverObjectOnMove = new Rover(2, 3, 'W');
	}
	@Test
	/* Ensure the rover's response to turn left sets
	 * correct direction. 
	 */
	public void testRoverResponseToLeftIsCorrect() {
		
		RoverObjectOnMove.turnLeft();
		assertEquals('S', RoverObjectOnMove.getDirection());
	}
	
	@Test
	/* Ensure the rover's response to turn right sets 
	 * correct direction. 
	 */
	public void testRoverResponseToRightIsCorrect() {
		RoverObjectOnMove.turnRight();
		assertEquals('N', RoverObjectOnMove.getDirection());
	}
	
	@After
	public void tearDown() {
		RoverObjectOnMove = null;
	}

}
