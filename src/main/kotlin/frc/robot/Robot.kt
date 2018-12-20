package frc.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj.livewindow.LiveWindow

import frc.robot.commands.*
import frc.robot.subsystems.*

class Robot: IterativeRobot() {
  /**
   * "Static" class members
   */
  companion object {
    val exampleSubsystem: ExampleSubsystem = ExampleSubsystem()
    var oi: OI? = null
    val driveTrainSubsystem: DriveTrainSubsystem = DriveTrainSubsystem()
    val sensorSubsystem: SensorSubsystem = SensorSubsystem()
  }

  var autonomousCommand: Command? = null
  var chooser: SendableChooser<Command> = SendableChooser()

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  override fun robotInit() {
    oi = OI()
    chooser.addObject("DriveForward", DriveForward(2.0, 1.0))
    chooser.addDefault("Default Auto", ExampleCommand())
    // chooser.addObject("My Auto", MyAutoCommand())
    SmartDashboard.putData("Auto mode", chooser)
    SmartDashboard.putData(sensorSubsystem.encoder)
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  override fun disabledInit() {}

  override fun disabledPeriodic () {
    Scheduler.getInstance().run()
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  override fun autonomousInit() {
    /*
     * val autoSelected: String = SmartDashboard.getString("Auto Selector", "Default")
     * autonomousCommand = when (autoSelected) {
     *   "My Auto" -> MyAutoCommand()
     *   "Default Auto" -> ExampleCommand()
     *   else -> ExampleCommand()
     * }
     */

    // schedule the autonomous command (example)
    chooser.selected?.start()
  }

  /**
   * This function is called periodically during autonomous
   */
  override fun autonomousPeriodic() {
    Scheduler.getInstance().run()
  }

  override fun teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    autonomousCommand?.start()
  }

  /**
   * This function is called periodically during operator control
   */
  override fun teleopPeriodic() {
    Scheduler.getInstance().run()
    println(sensorSubsystem.navXMicroBoard.getCompassHeading())
  }

  override fun testInit() {}

  /**
   * This function is called periodically during test mode
   */
  override fun testPeriodic() {
    println(sensorSubsystem.encoder.raw)
    Scheduler.getInstance().run()
  }
}