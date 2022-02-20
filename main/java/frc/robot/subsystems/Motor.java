package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Motor extends SubsystemBase{
    private WPI_TalonFX motor;
    public Motor(int port){
        motor = new WPI_TalonFX(port);
    }
    public void setSpeed(double speed){
        motor.set(speed);
    }
    public void stopMotor(){
        motor.set(0);
    }
}
