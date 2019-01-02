package frc.robot.pathfinder

import jaci.pathfinder.Pathfinder
import jaci.pathfinder.Trajectory
import jaci.pathfinder.Waypoint
import jaci.pathfinder.modifiers.TankModifier

class TankTrajectoryContainer(var leftTrajectory: Trajectory, var rightTrajectory: Trajectory) {
    constructor(modifier: TankModifier): this(modifier.getLeftTrajectory(), modifier.getRightTrajectory()) {}
}