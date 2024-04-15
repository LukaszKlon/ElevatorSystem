import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class Server(val elevatorNumber: Int, val numberOfFloors: Int,val driveTime: Int, val checkTime:Int) extends Actor{
  private val elevatorSystem: ElevatorSystem = new ElevatorSystem(elevatorNumber, numberOfFloors, driveTime, checkTime)

  override def receive: Receive = {
    case "Print" =>
      elevatorSystem.print()
    case ("PickUp", startFloor:Int,direction:Int) =>
      elevatorSystem.pickUp(startFloor, direction)
    case "Step" =>
      elevatorSystem.step()
    case "Status" =>
      elevatorSystem.status()
    case ("Update", elevatorNumber: Int, currentFloor: Int, finalFloor:Int) =>
      elevatorSystem.updated(elevatorNumber, currentFloor, finalFloor)
    case "Stop" =>
      println("Finish"); context.stop(self)
  }

}

