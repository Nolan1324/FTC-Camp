//The following line is automatically created when a new program is created
package org.firstinspires.ftc.teamcode;

//Import statments automatically created when hitting
// Alt+Enter after typing a new type of object (e.x. DcMotor, Servo)
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

//Before reading this, make sure you understand "Structure.java", "TwoWheelDrive.java", and "TimeDrive.java"

//Register the program on the driver station with the name "EncoderDrive"
@Autonomous(name="EncoderDrive")

//Set the class name and make it a LinearOpMode
public class EncoderDrive extends LinearOpMode {
    //Create DcMotor variables for the wheels
    DcMotor leftDrive;
    DcMotor rightDrive;


    //These variables are used to calculate the amount of encoder counts in an inch.
    // The word "final" is added before the data type because these variables will not change elsewhere in our program.
    // The word "static" is added beofre the data type because the variables are not dependent on anything else in our project.
    static final double COUNTS_PER_MOTOR_REV = 1440; // TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 2.0; // The gear ratio
    static final double WHEEL_DIAMETER_INCHES = 4.0; // The diameter of the wheels
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * Math.PI); //Calculate the counts per inch.

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

        //Call a method that waits for the match to start.
        waitForStart();

        //Autonomous code:

        //Go forward at 50% for 20 inches with a fail safe timeout of 3 seconds
        //The encoderDrive(speed, leftInches, rightInches, timeoutS) method is NOT built into FTC. Instead, we created our own method on line 62.
        encoderDrive(0.5, 20, 20, 3);
    }

    //A method NOT built into FTC that we, the programmer, are defining. It is call "encoderDrive" and passing the double parameters speed, leftInches, rightInches, and timeoutS.
    //We are defining this method to make it easier to use the encoders in a small amount of code.
    public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) {
        //Initialize variables to store our target encoder counts. The type is "int", a.k.a a whole number.
        int newLeftTarget;
        int newRightTarget;

        //The block if(opModeIsActive()) {} only runs the code in the {}s if the OpMode is still active.
        if (opModeIsActive()) {

            //The snippet (leftInches * COUNTS_PER_INCH) converts the inches to encoder counts using the constant defined earlier.
            //That snippet is proceeded by (int) because (leftInches * COUNTS_PER_INCH) is a double. Since encoder counts like to work in ints, we use (int) to "cast"
            // the double to an int.
            //Finally, we add this distance to the motor's current position, leftDrive.getCurrentPosition()
            newLeftTarget = leftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            //The same as above, with the right motor.
            newRightTarget = rightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);

            //Use the setTargetPosition(encoderCounts) method on the two wheels, passing in the target values we defined above.
            leftDrive.setTargetPosition(newLeftTarget);
            rightDrive.setTargetPosition(newRightTarget);

            //Use the setMode(mode) method that passes a mode. The mode can either be DcMotor.RunMode.RUN_TO_POSITION or DcMotor.RunMode.RUN_USING_ENCODER
            //The DcMotor.RunMode.RUN_TO_POSITION
            leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //Reset the timer
            runtime.reset();
            //Start moving the motors. We passed the speed variable through a method called Math.abs(a).
            //The method takes away the negative sign of the input, if the input has one.
            //This is because RUN_TO_POSITION mode does not like to work with negative powers.
            leftDrive.setPower(Math.abs(speed));
            rightDrive.setPower(Math.abs(speed));

            //Like in TimerRun.java, the while condition starts with opModeIsActive() &&
            //We give the method two more conditions by using the AND key (&&)
            //One condition checks that the timer has not exceeded the timeout. The timeout is a fail safe in case the motor encoders malfunction.
            //The other condition checks if the motors are running. This is because RUN_TO_POSITION mode will automatically stop the motors when we reach our goal.
            while (opModeIsActive() && (runtime.seconds() < timeoutS) && (leftDrive.isBusy() && rightDrive.isBusy())) {
                //Wait
                idle();
            }

            //Stop all of the motors
            leftDrive.setPower(0);
            rightDrive.setPower(0);

            //Turn off RUN_TO_POSITION mode
            leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}
