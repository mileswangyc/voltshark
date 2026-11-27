package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem implements Subsystem{
    protected OpMode opMode;

    DcMotor leftDrive;
    DcMotor rightDrive;

    @Override
    public void init(OpMode opMode) {

        this.opMode = opMode;
        leftDrive = opMode.hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = opMode.hardwareMap.get(DcMotor.class, "rightDrive");
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double leftPower  = -opMode.gamepad1.left_stick_y;
        double rightPower = opMode.gamepad1.right_stick_y;

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
}
