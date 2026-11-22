package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode {

   
    static final double TICKS_PER_REV = 560.0;

    @Override
    public void runOpMode() {
        
        DcMotor leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        
        DcMotorEx flywheel = hardwareMap.get(DcMotorEx.class, "flywheel");
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT); // Lets wheel coast smoothly

        
        double targetRPM = 240.0;
        double targetVelocity = (targetRPM * TICKS_PER_REV) / 60.0;

        waitForStart();

        while (opModeIsActive()) {
            
            double leftPower = -gamepad1.left_stick_y;
            double rightPower = -gamepad1.right_stick_y;
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

           
            if (gamepad1.a) {
                flywheel.setVelocity(targetVelocity);
            } else {
                flywheel.setVelocity(0);
            }

           
            double currentRPM = (flywheel.getVelocity() * 60.0) / TICKS_PER_REV;
            telemetry.addData("Target RPM", targetRPM);
            telemetry.addData("Actual RPM", "%.1f", currentRPM);
            telemetry.update();
        }
    }
}
