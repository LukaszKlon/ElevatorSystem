import akka.actor.{ActorSystem, Props}

object ElevatorControl{
  private var server:Option[akka.actor.ActorRef] = None
  private var actorSystem:Option[akka.actor.ActorSystem] = None
  def init(elevatorNumber: Int, numberOfFloors: Int, driveTime: Int, checkTime: Int): Unit = {
    actorSystem = Some(ActorSystem("ElevatorServer"))
    server = Some(actorSystem.get.actorOf(Props(new Server(elevatorNumber, numberOfFloors, driveTime, checkTime)), "server"))
  }

  def print(): Unit = {
    server.foreach(_ ! "Print")
  }

  def step(): Unit = {
    server.foreach(_ ! "Step")
  }

  def pickUp(startFloor: Int, direction: Int): Unit = {
    server.foreach(_ ! ("PickUp", startFloor, direction))
  }

  def update(elevatorNumber: Int, currentFloor: Int, finalFloor:Int): Unit = {
    server.foreach(_ ! ("Update", elevatorNumber,currentFloor,finalFloor))
  }

  def status(): Unit = {
    server.foreach(_ ! "Status")
  }

  def terminate(): Unit = {
    if (actorSystem != null){
      server.foreach(_ ! "Stop")
      actorSystem.get.terminate()
      //      restore system
      server = None
      actorSystem = None
    } else{
      println("Cannot stop\n")
    }
  }
}