// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//Creating Drive train class
public class DriveTrain extends SubsystemBase {

  //Creating motor variables
    private final WPI_TalonSRX _leftDriveTalon;
    private final WPI_TalonSRX _righttDriveTalon;

    private static DriveTrain instance;
  
    private DifferentialDrive _diffDrive;
  
  
    /** Creates a new DriveTrain. */
    public DriveTrain() {
      _leftDriveTalon = new WPI_TalonSRX(Constants.DriveTrainPorts.LeftDriveTalonPort);
      _righttDriveTalon = new WPI_TalonSRX(Constants.DriveTrainPorts.RightDriveTalonPort);
  
    // Makes sure motors are going forward
      _leftDriveTalon.setInverted(false);
      _righttDriveTalon.setInverted(false);
  
      _diffDrive = new DifferentialDrive(_leftDriveTalon, _righttDriveTalon);
  
  
    }
  //The method will run periodicly

  public static DriveTrain getInstance(){
    if(instance == null){
      instance = new DriveTrain(); //creates a new instance/object of DriveTrain if it does not exist already
    }
    return instance;
  }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }

  //Getting y-axis values and translates to speed
    public void tankDrive(double leftSpeed, double rightSpeed) {
      _diffDrive.tankDrive(leftSpeed, rightSpeed);
  
  
    }
  }