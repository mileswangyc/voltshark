package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "PollenPusherTeleOp")
public class PollenPusherTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor pollenPusher = hardwareMap.get(DcMotor.class, "pollenPusher");

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                pollenPusher.setPower(0.6);
            } else if (gamepad1.b) {
                pollenPusher.setPower(-0.6);
            } else {
                pollenPusher.setPower(0.0);
            }
        }
    }
}
