// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;


public class TimedAuto extends CommandBase {

  private double duration; //in seconds

  /** Creates a new TimedAuto. */
  public TimedAuto(double time) {
    RobotContainer.getDrive();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DriveTrain.getInstance());
    duration = time; 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.getTimer().reset(); //resets timer 
    RobotContainer.getTimer().start(); //starts timer
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.getTimer().get() < duration){  //as long as the timer returns a value less than the duration, then the robot will move forward, else it will stop
      RobotContainer.getDrive().tankDrive(0.5, 0.5);
    }
    else{
      RobotContainer.getDrive().tankDrive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.getDrive().tankDrive(0, 0); //robot will stop if interrupted
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (RobotContainer.getTimer().get() > duration); //when the timer returns a value greater than the duration
  }
}
