// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase { 
  /** Creates a new ExampleSubsystem. */
  private WPI_TalonFX frontLeft, frontRight, backLeft, backRight;
  private SpeedControllerGroup left, right;
  private double speedMultiplier = 1.0;
  private boolean isFast = true;
  private Joystick driver;
  public Drivetrain(Joystick drive) {
    frontLeft = new WPI_TalonFX(0);
    frontRight = new WPI_TalonFX(1);
    backLeft = new WPI_TalonFX(3);
    backRight = new WPI_TalonFX(2);

    left = new SpeedControllerGroup(frontLeft, backLeft);
    right = new SpeedControllerGroup(frontRight, backRight);

    driver = drive;

    //resetEncoders();  
  }
  
  public void tankDrive(double leftSpeed, double rightSpeed){
    setLeftSpeed(leftSpeed);
    setRightSpeed(-rightSpeed);
  }
  private void setLeftSpeed(double speed){
    left.set(speed * speedMultiplier);
  }
  private void setRightSpeed(double speed){
    right.set(speed * speedMultiplier);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
