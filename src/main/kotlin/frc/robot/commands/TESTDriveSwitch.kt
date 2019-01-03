package frc.robot.commands

import edu.wpi.first.wpilibj.command.CommandGroup
import jaci.pathfinder.Waypoint

import frc.robot.pathfinder.MotionExecutor

import frc.robot.Robot

class TESTDriveSwitch: CommandGroup() {
  init {
    //Add commands here using: addParallel or addSequential
    var waypoints = arrayOf(
      Waypoint(1.0, 13.0, 0.0),
      Waypoint(6.0, 18.0, 0.0)
    )
    val motionExecutor = MotionExecutor(Robot.motionProfiler.generateTankMotionProfile(waypoints))
    addSequential(TriggerMotionExecution(motionExecutor))
  }
}