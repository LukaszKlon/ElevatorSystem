import scala.collection.mutable.ListBuffer

object ElevatorSystemPrinter {
  
  private def addLine(stringList: ListBuffer[StringBuilder],elevatorNumber:Int): Unit = {
    for (i <- 0 to elevatorNumber + 1) {
      stringList(i).append("|")
    }
  }

  private def printOneElevator(stringList: ListBuffer[StringBuilder], elevator: Elevator,numberOfFloors: Int): Unit = {
    val list = elevator.getFloors
    stringList(numberOfFloors - elevator.floor).append(elevator)
    var i = 0
    for (j <- 0 to numberOfFloors) {
      i = numberOfFloors - j
      if (i != numberOfFloors - elevator.floor) {
        if (list.contains(j)) {
          stringList(i).append(".")
        }
        else {
          stringList(i).append(" ")
        }
      }
    }
  }

  def printElevators(numberOfFloors:Int, elevatorList: ListBuffer[Elevator],elevatorNumber: Int): Unit = {
    val stringList = ListBuffer[StringBuilder]()
    for (i <- 0 to numberOfFloors) {
      stringList += StringBuilder()
      stringList(i).append(numberOfFloors - i)
    }
    stringList.append(StringBuilder())
    stringList.last.append("E")
    addLine(stringList,elevatorNumber)
    var num = 0
    for (elevator <- elevatorList) {
      printOneElevator(stringList, elevator,numberOfFloors)
      stringList.last.append(num.toString)
      addLine(stringList,elevatorNumber)
      num = num + 1
    }

    val result = StringBuilder()
    for (i <- 0 to numberOfFloors + 1) {
      stringList(i).append("\n")
      result.append(stringList(i).toString())
    }

    println(result.toString)
  }
}
