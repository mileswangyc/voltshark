package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "drivingandflywheelandpollenpusher")
public class DrivingAndFlywheelAndPollenPusher extends LinearOpMode {

    //static final double TICKS_PER_REV = 560.0;

    // Pollen pusher servo positions (tune these on your robot)
    static final double PUSHER_RETRACTED = 0.0;
    static final double PUSHER_EXTENDED  = 0.6;

    @Override
    public void runOpMode() {

        DcMotor leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotorEx flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT); // Lets wheel coast smoothly

        Servo pollenPusher = hardwareMap.get(Servo.class, "pollenPusher");
        pollenPusher.setPosition(PUSHER_RETRACTED);

        //double targetRPM = 240.0;
        //double targetVelocity = (targetRPM * TICKS_PER_REV) / 60.0;
        double targetVelocity = 2240;
        waitForStart();

        while (opModeIsActive()) {

            // ---------- GAMEPAD 1: DRIVING ----------
            double leftPower = -gamepad1.left_stick_y;
            double rightPower = gamepad1.right_stick_y;
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            // ---------- GAMEPAD 2: MECHANISMS ----------
            // Flywheel: hold A
            if (gamepad2.a) {
                flywheel.setVelocity(targetVelocity);
            } else {
                flywheel.setVelocity(0);
            }

            // Pollen pusher: X = push, B = retract
            if (gamepad2.x) {
                pollenPusher.setPosition(PUSHER_EXTENDED);
            } else if (gamepad2.b) {
                pollenPusher.setPosition(PUSHER_RETRACTED);
            }

            telemetry.addData("Target Velocity", targetVelocity);
            telemetry.addData("Actual Velocity", "%.1f", flywheel.getVelocity());
            telemetry.addData("Pusher Position", "%.2f", pollenPusher.getPosition());
            telemetry.update();
        }
    }
}
