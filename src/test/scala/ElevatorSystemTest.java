import org.junit.Test;
import scala.collection.mutable.ListBuffer;

import static org.junit.Assert.*;

public class ElevatorSystemTest {

    @Test
    public void pickUp() {
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,5,1,2);
        assertEquals(0,elevatorSystem.pickUp(2,1));
    }

    @Test
    public void updatedFinished() {
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,5,1,2);
        assertTrue(elevatorSystem.updated(0, 0, 1));
    }

    @Test
    public void updatedNotFinished() {
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,5,1,2);
        assertFalse(elevatorSystem.updated(0, 1, 2));
    }
    
}