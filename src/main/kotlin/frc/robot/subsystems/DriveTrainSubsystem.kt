package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.robot.RobotMap
/**
 *
 */
class DriveTrainSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private val driveleft0 = PWMVictorSPX(RobotMap.driveTrainLeft0)
  private val driveleft1 = PWMVictorSPX(RobotMap.driveTrainLeft1)
  private val driveright0 = PWMVictorSPX(RobotMap.driveTrainRight0)
  private val driveright1 = PWMVictorSPX(RobotMap.driveTrainRight1)

  private val driveleftgroup = SpeedControllerGroup(driveleft0, driveleft1)
  private val driverightgroup = SpeedControllerGroup(driveright0, driveright1)
  
  private val myrobot = DifferentialDrive(driveleftgroup, driverightgroup)
  
  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  fun tankdrive(left: Double, right: Double) = this.myrobot.tankDrive(left, right, false)
  
}