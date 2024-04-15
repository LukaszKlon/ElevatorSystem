import java.lang.Math
import scala.collection.mutable
import scala.collection.mutable.HashSet


class Elevator (var floor: Int,val totalFloors:Int,var direction: Int,val driveTime: Int,val checkTime: Int) {
//  direction -1 elevator go down direction 1 elevator go up 0 stay
  private val futureVisitingFloors =  mutable.HashSet[Int]()

  def this(totalFloors:Int,driveTime:Int,checkTime:Int) = this(0,totalFloors,0,driveTime,checkTime)

  def addFloor(newFloor:Int): Unit ={
    futureVisitingFloors.add(newFloor)
    if (direction == 0){
      if ( floor < newFloor){
        direction = 1
      }
      else if (floor > newFloor) {
        direction = -1
      }
    }
  }

  def getFloors: List[Int] = futureVisitingFloors.toList
  def getNumberOfFloors: Int = futureVisitingFloors.size

  private def removeFloor(): Unit = {
    if (futureVisitingFloors.contains(floor)){
      futureVisitingFloors.remove(floor)
      if (futureVisitingFloors.isEmpty ) direction = 0
    }
  }

  def lastFloor: Int= {
    if (direction == 1) {
      if (floor > futureVisitingFloors.min) futureVisitingFloors.min
      else futureVisitingFloors.max
    }
    else if (direction == -1){
      if (floor < futureVisitingFloors.max) futureVisitingFloors.max
      else futureVisitingFloors.min
    }
    else floor
  }

  def calculateTimeEfficient(pickUpFloor: Int, directionNew: Int): Int ={
    EfficientCalculatorAlgorithm.calculateTimeEfficient(pickUpFloor, directionNew,
      futureVisitingFloors, floor, direction, driveTime, checkTime,totalFloors)
  }

  private def changeDirection(): Unit ={
    if (direction == 1 && EfficientCalculatorAlgorithm.getHigherFloors(floor,futureVisitingFloors) == 0){
      if (futureVisitingFloors.isEmpty) direction = 0
      else direction = -1
    }
    else if (direction == -1 && EfficientCalculatorAlgorithm.getLowerFloors(floor,futureVisitingFloors) == 0) {
      if (futureVisitingFloors.isEmpty) direction = 0
      else direction = 1
    }
  }

  def simulateMove(): Unit = {
    direction match
      case -1 =>
        floor = Math.max(floor-1,0)
        removeFloor()
        changeDirection()
      case 1 =>
        floor = Math.min(floor+1,totalFloors)
        removeFloor()
        changeDirection()
      case 0 => floor = floor
  }

  override def toString: String = {
    if (direction == -1) "v"
    else if (direction == 0) "-"
    else "^"
  }

}
