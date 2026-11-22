package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "DriveForwardHalfPower")
public class DriveForwardHalfPower extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor leftDrive  = hardwareMap.get(DcMotor.class, "leftDrive");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");



        // Brakes cleanly when power is set to 0
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        if (opModeIsActive()) {
            leftDrive.setPower(-0.5);
            rightDrive.setPower(0.5);
            sleep(1000);

            leftDrive.setPower(0);
            rightDrive.setPower(0);
        }
    }
}
