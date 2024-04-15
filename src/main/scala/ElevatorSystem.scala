import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.break

class ElevatorSystem(val elevatorNumber: Int, val numberOfFloors: Int,val driveTime: Int, val checkTime:Int) {

  private val elevatorList: ListBuffer[Elevator] = ListBuffer()

  for(i <- 0 until elevatorNumber){
    elevatorList.append(new Elevator(numberOfFloors,driveTime,checkTime))
  }

  def pickUp(startFloor:Int,direction:Int): Int ={
    var index = 0
    var minimumCost = elevatorList.head.calculateTimeEfficient(startFloor,direction)
    var tmp = 0
    for (i <- 1 until elevatorNumber) {
      tmp =elevatorList(i).calculateTimeEfficient(startFloor,direction)
      if (minimumCost > tmp){
        minimumCost = tmp
        index = i
      }
    }
    if (elevatorList(index).floor != startFloor){
      elevatorList(index).addFloor(startFloor)
    }
    index
  }

  def updated(elevatorNumber: Int, currentFloor: Int, finalFloor:Int):Boolean ={
    if (elevatorList(elevatorNumber).floor == currentFloor){
      elevatorList(elevatorNumber).addFloor(finalFloor)
      true
    }
    else{
      false
    }
  }

  def step(): Unit = {
    for(elevator <- elevatorList){
      elevator.simulateMove()
    }
  }

  def status(): ListBuffer[(Int,Int,Int)] = {
    val list = new ListBuffer[(Int,Int,Int)]
    var i = 0
    for (elevator <- elevatorList) {
      list :+ (i, elevator.floor, elevator.lastFloor)
      println("Elevator: " + i + " floor: " + elevator.floor + " last floor: "+ elevator.lastFloor)
      i += 1
    }
    list
  }

  def print():Unit ={
    ElevatorSystemPrinter.printElevators(numberOfFloors, elevatorList, elevatorNumber)
  }
}
