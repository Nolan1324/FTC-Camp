//The following line is automatically created when a new program is created
package org.firstinspires.ftc.teamcode;

//Import statments automatically created when hitting
// Alt+Enter after typing a new type of object (e.x. DcMotor, Servo)
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.ColorSensor;

//Register the program on the driver station with the name "Time Drive"
@Autonomous(name="Time Drive")

//Set the class name and make it a LinearOpMode
public class TwoWheelDrive extends OpMode {

    //Create DcMotor variables for the wheels
    DcMotor leftDrive;
    DcMotor rightDrive;

    @Override
    public void runOpMode() throws InterruptedException {
		//Init code will go before waitForStart();
		
        //Map the wheel variables to their respective config names
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");

        //Reverse the right drive motor
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
		
		waitForStart();
		
		//Autonomous code
		
		//Start moving the wheels
		leftDrive.setPower(0.5);
		rightDrive.setPower(0.5);
		
		//Wait 2000 miliseconds (2 seconds)
		sleep(2000);
		
		//Stop moving the wheels
		leftDrive.setPower(0.5);
		rightDrive.setPower(0.5);
    }
}
