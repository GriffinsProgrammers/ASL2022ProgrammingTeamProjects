// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limit_Switch;
import frc.robot.subsystems.Piston;
import frc.robot.subsystems.Motor;
import static frc.robot.Constants.*;

/** An example command that uses an example subsystem. */
public class Catapult extends CommandBase {
  private long initTime;

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Limit_Switch bottomSwitch;
  private Piston p1;
  private Motor m1;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Catapult() {
    bottomSwitch = new Limit_Switch(PORT_BOTTOM_LS);
    p1 = new Piston(PORT_CATAPULT_DS_1, PORT_CATAPULT_DS_2);
    m1 = new Motor(PORT_CATAPULT_MOTOR);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(bottomSwitch);
    addRequirements(p1);
    addRequirements(m1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (bottomSwitch.getPressed()) {
      p1.open();
    }
    initTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    while (!bottomSwitch.getPressed()){
      m1.setSpeed(1);
    }
    m1.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if ((System.currentTimeMillis() - 500 ) > initTime) {
      return true;
    }
    return false;
  }
}
