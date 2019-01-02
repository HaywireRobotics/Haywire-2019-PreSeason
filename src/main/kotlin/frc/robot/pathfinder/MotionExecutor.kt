package frc.robot.pathfinder

import jaci.pathfinder.Pathfinder
import jaci.pathfinder.Trajectory
import jaci.pathfinder.Waypoint

import java.util.Timer
import java.util.TimerTask

class MotionExecutor () {
    val timer: Timer = Timer()
    init {
        timer.schedule(Looper(this), 5 * 1000)
    }
}

class Looper(val parentObject: MotionExecutor) : TimerTask() {
    override fun run() {
        println("Hello World")
        parentObject.timer.cancel()
    }
}