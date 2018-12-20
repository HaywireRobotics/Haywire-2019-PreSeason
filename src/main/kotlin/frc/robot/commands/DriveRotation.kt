package frc.robot.commands

import edu.wpi.first.wpilibj.command.Command

import frc.robot.Robot

/**
 *
 */
class DriveRotation(rotations: Int): Command() {

  // 1 foot ~ 1200
  private var targetRot: Int = 2600 * 3
  private var leftSpeed: Double = 0.5
  private var rightSpeed: Double = 0..5

  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrainSubsystem)
    requires(Robot.sensorSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize () {
    //TODO("Not Implemented")
    Robot.sensorSubsystem.encoder1.reset()
    Robot.sensorSubsystem.encoder2.reset()
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    //TODO("Not Implemented")
    if (Robot.sensorSubsystem.encoder1.raw > Robot.sensorSubsystem.encoder2.raw) {
      leftSpeed -= 0.001
    }
    else if (Robot.sensorSubsystem.encoder1.raw < Robot.sensorSubsystem.encoder2.raw) {
      leftSpeed += 0.001
    }
    Robot.driveTrainSubsystem.tankdrive(leftSpeed, rightSpeed)
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished (): Boolean {
    return (Robot.sensorSubsystem.encoder1.raw > targetRot && Robot.sensorSubsystem.encoder2.raw > targetRot)
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun end () {
    //TODO("Not Implemented")
    Robot.driveTrainSubsystem.tankdrive(0.0, 0.0)
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted () {
    //TODO("Not Implemented")
  }
}