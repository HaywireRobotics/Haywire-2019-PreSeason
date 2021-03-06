package frc.robot

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
object RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // val leftMotor = 1
  // val rightMotor = 2

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // val rangefinderPort = 1
  // val rangefinderModule = 1

  val driveTrainLeft0 = 0
  val driveTrainLeft1 = 1
  val driveTrainRight0 = 2
  val driveTrainRight1 = 3
}