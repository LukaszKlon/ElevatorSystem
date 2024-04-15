import scala.collection.mutable

object EfficientCalculatorAlgorithm {


  def getHigherFloors(floor: Int,futureVisitingFloors:mutable.HashSet[Int]): Int = futureVisitingFloors.count(key => key > floor)

  def getLowerFloors(floor: Int,futureVisitingFloors:mutable.HashSet[Int]): Int = futureVisitingFloors.count(key => key < floor)

  private def getFloorsBetween(floor1: Int,floor2: Int,futureVisitingFloors:mutable.HashSet[Int]): Int = futureVisitingFloors.count(key => Math.min(floor1, floor2) < key && key < Math.max(floor1, floor2))
  
  
  def calculateTimeEfficient(pickUpFloor: Int, directionNew: Int,
                             futureVisitingFloors:mutable.HashSet[Int],floor:Int,
                             direction:Int, driveTime:Int,checkTime:Int,totalFloors:Int): Int = {
    var min = 0
    var max = 0
    var add = 0
    if (futureVisitingFloors.nonEmpty) {
      min = Math.min(futureVisitingFloors.min, floor)
      max = Math.max(futureVisitingFloors.max, floor)
    }
    if (directionNew != direction) {
      add = totalFloors
    }

    if (direction == -1) {
      if (pickUpFloor <= floor) getFloorsBetween(pickUpFloor, floor,futureVisitingFloors) * checkTime + (floor - pickUpFloor) * driveTime + add*driveTime
      else getLowerFloors(pickUpFloor,futureVisitingFloors) * checkTime + (floor + pickUpFloor - 2 * min) * driveTime + add*driveTime
    }
    else if (direction == 0) {
      Math.abs(pickUpFloor - floor) * driveTime
    }
    else {
      if (pickUpFloor >= floor) getFloorsBetween(pickUpFloor, floor,futureVisitingFloors) * checkTime + (pickUpFloor - floor) * driveTime + add * driveTime
      else getHigherFloors(pickUpFloor,futureVisitingFloors) * checkTime + (2 * max - (floor + pickUpFloor)) * driveTime + add * driveTime
    }
  }
}
