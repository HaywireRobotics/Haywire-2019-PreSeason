package frc.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.robot.pathfinder.MotionExecutor

import frc.robot.Robot

/**
 *
 */
class TriggerMotionExecution(val motionExecutor: MotionExecutor): Command() {
  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.exampleSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize () {
    //TODO("Not Implemented")
  }

  // Called repeatedly when this Command is scheduled to run
  override fun execute () {
    //TODO("Not Implemented")
    motionExecutor.start()
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished (): Boolean {
    return true
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun end () {
    //TODO("Not Implemented")
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted () {
    //TODO("Not Implemented")
  }
}