package frc.robot.commands

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.Timer
import frc.robot.Robot

/**
 *
 */
class DriveForward(seconds: Double, speed: Double): Command() {

  private val time: Timer = Timer()
  private var seconds: Double = seconds
  private var speed: Double = speed

  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrainSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize () {
    //TODO("Not Implemented")
    this.time.reset()
    this.time.start()
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    //TODO("Not Implemente
    Robot.driveTrainSubsystem.tankdrive(this.speed, this.speed)
    
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished (): Boolean {
    return this.time.hasPeriodPassed(seconds)
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