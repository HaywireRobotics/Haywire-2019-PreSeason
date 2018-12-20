package frc.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.SerialPort
import com.kauailabs.navx.frc.*

/**
 *
 */
class SensorSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  val encoder: Encoder = Encoder(0, 1)
  val navXMicroBoard: AHRS = AHRS(SerialPort.Port.kUSB)

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}