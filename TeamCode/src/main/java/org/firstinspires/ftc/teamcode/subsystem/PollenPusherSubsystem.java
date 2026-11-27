package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class PollenPusherSubsystem implements Subsystem {
    protected OpMode opMode;
    Servo pollenPusher;

    @Override
    public void init(OpMode opMode) {
        this.opMode = opMode;
        pollenPusher = opMode.hardwareMap.get(Servo.class, "pollenPusher");
    }

    @Override
    public void loop() {
        if (opMode.gamepad1.dpad_up) {
             pollenPusher.setPosition(0);
        }
         else if (opMode.gamepad1.dpad_down) {
             pollenPusher.setPosition(1.0);
        }
    }
}
