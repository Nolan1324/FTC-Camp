//The following line is automatically created when a new program is created
package org.firstinspires.ftc.teamcode;

//Import statments automatically created when hitting
// Alt+Enter after typing a new type of object (e.x. DcMotor, Servo)
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOp
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

//Before reading this, make sure you understand "Structure.java" and "TwoWheelDrive.java"

//Register the program on the driver station with the name "TimeDrive"
@Autonomous(name="TimeDrive")

//Set the class name and make it a LinearOpMode
public class TwoWheelDrive extends OpMode {

    //Create DcMotor variables for the wheels
    DcMotor leftDrive;
    DcMotor rightDrive;
     
    //Define an ElapsedTime variable called "runtime" and set it to a new ElapsedTime object.
    //To create a new object, the syntax is new ObjectName(parameters);
    //This is must likley the only time you will see a constructor in FTC, if you keep to the basics.
    ElapsedTime runtime = new ElapsedTime();

    //A method built into LinearOpMode called "runOpMode". Unlike "loop", this will run only once.
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
		
	//Reset the timer
	runtime.reset();
	    
	//A while block. While keep runing as long the statment in ()s after "while" is true
	//All LinearOpMode loops should contain "opModeIsActive() &&". After "&&", put your condition.
	//In this case, the condition is if the time is less 1.0 second. If the time exceeds 1.0 second, the conditon
	// becomes false and the program can move on.
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            //Wait
	    idle();
        }
		
	//Stop moving the wheels
	leftDrive.setPower(0.0);
	rightDrive.setPower(0.0);
    }
}
