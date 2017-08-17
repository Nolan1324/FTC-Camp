package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Nolan on 8/17/2017.
 */

@Autonomous(name = "AUTO")

public class AutoBB extends LinearOpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;

    DcMotor arm;

    Servo leftClaw;
    Servo rightClaw;

    @Override
    public void runOpMode() throws InterruptedException {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        arm = hardwareMap.dcMotor.get("arm");

        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        leftClaw = hardwareMap.servo.get("leftClaw");
        rightClaw = hardwareMap.servo.get("rightClaw");

        waitForStart();

        leftDrive.setPower(1.0);
        rightDrive.setPower(1.0);

        wait(3000);

        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
    }
}
