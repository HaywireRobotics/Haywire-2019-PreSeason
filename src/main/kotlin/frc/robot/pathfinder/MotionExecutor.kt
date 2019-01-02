package frc.robot.pathfinder

import jaci.pathfinder.Pathfinder
import jaci.pathfinder.Trajectory
import jaci.pathfinder.Waypoint
import jaci.pathfinder.followers.EncoderFollower

import java.util.Timer
import java.util.TimerTask

import frc.robot.Robot
import frc.robot.RobotMap

class MotionExecutor (val trajectoryContainer: TankTrajectoryContainer) {
    val leftFollower: EncoderFollower = EncoderFollower(trajectoryContainer.leftTrajectory)
    val rightFollower: EncoderFollower = EncoderFollower(trajectoryContainer.rightTrajectory)
    
    init {  // Encoder configuration
        leftFollower.configureEncoder(Robot.sensorSubsystem.encoder1.raw, RobotMap.encoderTicksPerRevolution, RobotMap.wheelbaseWidth)
        rightFollower.configureEncoder(Robot.sensorSubsystem.encoder2.raw, RobotMap.encoderTicksPerRevolution, RobotMap.wheelbaseWidth)
    }

    init { // PIDVA configuration
        leftFollower.configurePIDVA(RobotMap.proportionalGain, RobotMap.integralGain, RobotMap.derivativeGain, 1 / RobotMap.maxVelocity, RobotMap.accelerationGain)
        rightFollower.configurePIDVA(RobotMap.proportionalGain, RobotMap.integralGain, RobotMap.derivativeGain, 1 / RobotMap.maxVelocity, RobotMap.accelerationGain)
    }
    // For the timer tasks
    // val timer: Timer = Timer()
    // init {
    //     timer.schedule(Looper(this), 5 * 1000)
    // }
}

// class Looper(val parentObject: MotionExecutor) : TimerTask() {
//     override fun run() {
//         println("Hello World")
//         parentObject.timer.cancel()
//     }
// }