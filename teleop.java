package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() {

        DcMotor leftDrive  = hardwareMap.get(DcMotor.class, "leftDrive");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");

        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor pollenPusher = hardwareMap.get(DcMotor.class, "pollenPusher");
        pollenPusher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        
        while (opModeIsActive()) {
            double leftPower  = -gamepad1.left_stick_y;
            double rightPower = gamepad1.right_stick_y;

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            if (gamepad1.dpad_up) {
                pollenPusher.setPower(0.6); 
            } else if (gamepad1.dpad_down) {
                pollenPusher.setPower(-0.6); 
            } else {
                pollenPusher.setPower(0.0);  
            }
        }
    }
}
