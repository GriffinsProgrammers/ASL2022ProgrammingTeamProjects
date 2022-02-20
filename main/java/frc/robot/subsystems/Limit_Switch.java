package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limit_Switch extends SubsystemBase {
    private DigitalInput limitSwitch;
    public Limit_Switch(int port){
        limitSwitch = new DigitalInput(port);
    }

    public boolean getPressed(){
        return limitSwitch.get();
    }
}