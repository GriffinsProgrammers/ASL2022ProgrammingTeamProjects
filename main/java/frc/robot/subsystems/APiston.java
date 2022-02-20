package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;


public class APiston extends SubsystemBase {
    private Joystick driver;
    Solenoid flag = new Solenoid(4);
    public APiston(Joystick drive){
    }
    public void open(){
        flag.set(true);
    }
    public void close(){
        flag.set(false);
    }
    }

