import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Basic")

public class Structure extends OpMode {

    DcMotor motor1;

    double power = 0.75;

    @Override
    public void init() {
        motor1 = hardwareMap.dcMotor.get("leftDrive");
    }

    @Override
    public void loop() {
        motor1.setPower(power);
    }
}
