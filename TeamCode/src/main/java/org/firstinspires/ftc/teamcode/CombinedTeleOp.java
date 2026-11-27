package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystem.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystem.PollenPusherSubsystem;
import org.firstinspires.ftc.teamcode.subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystem.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.subsystem.Subsystem;

import java.util.ArrayList;
import java.util.Arrays;

@TeleOp(name = "Combined TeleOp")
public class CombinedTeleOp extends OpMode {
    protected DriveSubsystem driveSubsystem;
    protected PollenPusherSubsystem pollenPusherSubsystem;
    protected IntakeSubsystem intakeSubsystem;
    protected ShooterSubsystem shooterSubsystem;
    ArrayList<Subsystem> subsystems;

    public CombinedTeleOp() {
        this.driveSubsystem = new DriveSubsystem();
        this.pollenPusherSubsystem = new PollenPusherSubsystem();
        this.intakeSubsystem = new IntakeSubsystem();
        this.shooterSubsystem = new ShooterSubsystem();
        subsystems = new ArrayList<Subsystem>(Arrays.asList(driveSubsystem, pollenPusherSubsystem, intakeSubsystem, shooterSubsystem));
    }

    @Override
    public void init() {
        for (Subsystem subsystem : subsystems) {
            subsystem.init(this);
        }
    }

    @Override
    public void loop() {
        for (Subsystem subsystem : subsystems) {
            subsystem.loop();
        }
    }
}
