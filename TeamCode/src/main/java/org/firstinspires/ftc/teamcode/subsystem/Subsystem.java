package org.firstinspires.ftc.teamcode.subsystem;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public interface Subsystem {
    public abstract void init(OpMode opMode);
    public abstract void loop();
}
