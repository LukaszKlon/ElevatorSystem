import org.junit.Test;

import static org.junit.Assert.*;

public class ElevatorTest {

    @Test
    public void calculateTimeEfficient0Direction() {
        Elevator elevator = new Elevator(0,10,0,1,2);
        assertEquals(3,elevator.calculateTimeEfficient(3,1));
    }

    @Test
    public void calculateTimeEfficient1Direction() {
        Elevator elevator = new Elevator(1,10,1,1,2);
        elevator.addFloor(2);
        elevator.addFloor(4);
        elevator.addFloor(6);
        assertEquals(12,elevator.calculateTimeEfficient(7,1));
    }

    @Test
    public void calculateTimeEfficient1DirectionPickFloorIsLowerThanFloor() {
        Elevator elevator = new Elevator(7,10,1,1,2);
        elevator.addFloor(2);
        elevator.addFloor(4);
        elevator.addFloor(6);
        elevator.addFloor(8);
        assertEquals(17,elevator.calculateTimeEfficient(0,1));
    }

    @Test
    public void calculateTimeEfficientMinus1Direction() {
        Elevator elevator = new Elevator(9,10,-1,1,2);
        elevator.addFloor(2);
        elevator.addFloor(4);
        elevator.addFloor(6);
        elevator.addFloor(8);
        assertEquals(26,elevator.calculateTimeEfficient(1,1));
    }

    @Test
    public void calculateTimeEfficientMinus1DirectionSecondCase() {
        Elevator elevator = new Elevator(9,10,-1,1,2);
        elevator.addFloor(2);
        elevator.addFloor(4);
        elevator.addFloor(6);
        assertEquals(31,elevator.calculateTimeEfficient(10,1));
    }

    @Test
    public void addFloorSize() {
        Elevator elevator = new Elevator(10,2,1);
        elevator.addFloor(4);
        elevator.addFloor(5);
        assertEquals(2,elevator.getNumberOfFloors());
    }

    @Test
    public void simulateMoveDirection0() {
        Elevator elevator = new Elevator(0,10,0,1,2);
        elevator.simulateMove();
        assertEquals(0,elevator.floor());
    }
    @Test
    public void simulateMoveDirection1() {
        Elevator elevator = new Elevator(0,10,1,1,2);
        elevator.simulateMove();
        assertEquals(1,elevator.floor());
    }
    @Test
    public void simulateMoveDirection1OutOfRange() {
        Elevator elevator = new Elevator(10,10,1,1,2);
        elevator.simulateMove();
        assertEquals(10,elevator.floor());
    }
    @Test
    public void simulateMoveDirectionMinus1() {
        Elevator elevator = new Elevator(2,10,-1,1,2);
        elevator.simulateMove();
        assertEquals(1,elevator.floor());
    }
    @Test
    public void simulateMoveDirectionMinus1OutOfRange() {
        Elevator elevator = new Elevator(0,10,-1,1,2);
        elevator.simulateMove();
        assertEquals(0,elevator.floor());
    }

    @Test
    public void lastFloorDirection1() {
        Elevator elevator = new Elevator(0,10,1,1,2);
        elevator.addFloor(2);
        elevator.addFloor(4);
        elevator.addFloor(6);
        assertEquals(6,elevator.lastFloor());
    }

    @Test
    public void lastFloorDirection1PickUnderFloor() {
        Elevator elevator = new Elevator(3,10,1,1,2);
        elevator.addFloor(2);
        elevator.addFloor(4);
        elevator.addFloor(6);
        assertEquals(2,elevator.lastFloor());
    }

    @Test
    public void lastFloorDirectionMinus1() {
        Elevator elevator = new Elevator(8,10,-1,1,2);
        elevator.addFloor(2);
        elevator.addFloor(4);
        elevator.addFloor(6);
        assertEquals(2,elevator.lastFloor());
    }

    @Test
    public void lastFloorDirectionMinus1PickUnderFloor() {
        Elevator elevator = new Elevator(3,10,-1,1,2);
        elevator.addFloor(2);
        elevator.addFloor(4);
        elevator.addFloor(6);
        assertEquals(6,elevator.lastFloor());
    }

}