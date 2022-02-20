package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Piston extends SubsystemBase {
    private DoubleSolenoid piston;

    public Piston(int port1, int port2){
        piston = new DoubleSolenoid(port1, port2);
    }
    public void open(){
        piston.set(DoubleSolenoid.Value.kForward);
    }
    public void close(){
        piston.set(DoubleSolenoid.Value.kOff);
    }
    public void reverse(){
        piston.set(DoubleSolenoid.Value.kReverse);
    }

}
