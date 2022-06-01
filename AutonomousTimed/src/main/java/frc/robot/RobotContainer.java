// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TimedAuto;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private Command m_autoCommand;

  private static DriveTrain m_drive = new DriveTrain();
  private static Timer m_timer = new Timer();
  private static Joystick joy = new Joystick(Constants.DriveTrainPorts.joy);
  private static Joystick joy1 = new Joystick(Constants.DriveTrainPorts.joy1);

  public static Joystick getJoy(){
        return joy;
  }

    public static Joystick getJoy1(){
        return joy1;
  }

  public static DriveTrain getDrive(){
        return m_drive;
  }

  public static Timer getTimer(){
    return m_timer;
  }
    


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    m_autoCommand = new TimedAuto(5); //the duration will be 5 seconds

    // An ExampleCommand will run in autonomous

    return m_autoCommand;
  }
}
