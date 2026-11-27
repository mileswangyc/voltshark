package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class IntakeSubsystem implements Subsystem {
    protected OpMode opMode;
    DcMotor intake;

    @Override
    public void init(OpMode opMode) {
        this.opMode = opMode;
        intake  = opMode.hardwareMap.get(DcMotor.class, "intake");
    }

    @Override
    public void loop() {
        double intakePower= -opMode.gamepad1.left_stick_y;

        intake.setPower(intakePower);
    }
}
