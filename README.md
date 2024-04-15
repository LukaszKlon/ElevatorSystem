# ElevatorSystem
This is elevator system manager which use scala and akka to managed elevators. 

# Idea of Solution
The solution involves creating an Elevator system within an actor thread. This process emulates server. After initialization, we can comunicate with system using comands inside ElevatorControl.

# Algorithm
The algorithm is based on two parameters: driveTime, representing the duration the elevator spends driving, and checkTime, representing the time the elevator spends at each floor. We calculate the number of floors are between current floor and destination floor where elevator stop and multiply this count by checkTime, calculate number of floors between current floor and destination and sum two values. If directions are different add all floors number to sum. Our algorithm try to minimalize cost.

# How to use?
1. Open scala REPL
2. write ElevatorControl.init(parmeters)
3. now we can use comands inside ElevatorControl to comunicate with 'server' (print,step,update,pickUp,status)
4. ElevatorControl.terminate() server finishes work
