package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "DriveForwardHalfPower")
public class DriveForwardHalfPower extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor leftDrive  = hardwareMap.get(DcMotor.class, "leftDrive");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");

        DcMotor pollenPusher = hardwareMap.get(DcMotor.class, "pollenPusher");

        // Brakes cleanly when power is set to 0
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        pollenPusher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        if (opModeIsActive()) {
            
            leftDrive.setPower(-0.5);
            rightDrive.setPower(0.5);
            sleep(1000);

            leftDrive.setPower(0);
            rightDrive.setPower(0);

            sleep(10000);

            pollenPusher.setPower(0.6);  
            sleep(1500);                 
            pollenPusher.setPower(0.0);
        }
    }
}
