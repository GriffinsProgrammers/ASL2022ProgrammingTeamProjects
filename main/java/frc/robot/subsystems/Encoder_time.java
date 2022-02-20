package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Joystick;

public class Encoder_time {
    private TalonFX motor;
    private Joystick j;

    public Encoder_time() {
        motor = new TalonFX(0);
        j = new Joystick(1);
    }

    public void setPos(int pos) {
        motor.set(ControlMode.Position, pos);
    }

    public void joystickTime() {
        motor.set(ControlMode.Position, (int) ((j.getDirectionDegrees() / 360 * 2048) + 0.5));
    }
}
