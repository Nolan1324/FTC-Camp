//The following line is automatically created when a new program is created
package org.firstinspires.ftc.teamcode;

//Import statments automatically created when hitting
// Alt+Enter after typing a new type of object (e.x. DcMotor, Servo)
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

//Register the program on the driver station with the name "Basic"
@TeleOp(name="Basic")

//Set the class name and make it an OpMode
public class TwoWheelDrive extends OpMode {

    //Create DcMotor variables for the wheels
    DcMotor leftDrive;
    DcMotor rightDrive;

    //Create a Servo variable for an arm
    Servo arm;

    //Create a decimal variable to store general power
    //The world "final" means that the variable is a constant (i.e. it cannot be editing elsewhere in the code)
    final double power = 0.75;

    @Override
    public void init() {
        //Map the wheel variables to their respect config names
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        //Map the arm variable to its respective config name
        arm = hardwareMap.servo.get("arm");

        //Reverse the right drive motor
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        //Set the power of the wheels to the joy stick values multiplied by the power constant
        leftDrive.setPower(gamepad1.left_stick_y);
        rightDrive.setPower(gamepad1.right_stick_y);

        if(gamepad1.a) {
            //If "a" is being pressed:

            //Set the arm's servo to its maximum rotation
            arm.setPosition(1.0);
        } else if(gamepad1.b) {
            //If "b" is being pressed:

            //Set the arm's servo to its minimum rotation
            arm.setPosition(-1.0);
        }

        //An example of using a telemetry to display info on the
        // driver station. This feature is meant for debugging
        //This example displays the left joystick's x coordinate as "Left Power".
        // This may be used, for example, testing if the controller works or
        // seeing what values the joystick returns.
        telemetry.addData("Left Power", gamepad1.left_stick_y);

        //Update the added telemetries so they display on the driver station
        telemetry.update();
    }
}
