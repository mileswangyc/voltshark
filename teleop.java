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

        waitForStart();

        while (opModeIsActive()) {
            double leftPower  = -gamepad1.left_stick_y;
            double rightPower = gamepad1.right_stick_y;

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
        }
    }
}
