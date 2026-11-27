package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class ShooterSubsystem implements Subsystem{
    protected OpMode opMode;
    DcMotor flywheel;

    @Override
    public void init(OpMode opMode) {
        this.opMode = opMode;
        flywheel = opMode.hardwareMap.get(DcMotor.class, "flywheel");

        flywheel.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(opMode.gamepad1.right_trigger_pressed)
        {
            flywheel.setPower(-0.55);
        }
    }
}
