import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Basic")

public class TwoWheelDrive extends OpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;

    Servo arm;

    final double power = 0.75;

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        arm = hardwareMap.servo.get("arm");
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        leftDrive.setPower(gamepad1.left_stick_y);
        rightDrive.setPower(gamepad1.right_stick_y);

        if (gamepad1.a) {
            arm.setPosition(1.0);
        } else if (gamepad1.b) {
            arm.setPosition(-1.0);
        }
        telemetry.addData("Left Power", gamepad1.left_stick_y);
        telemetry.update();
    }
}
