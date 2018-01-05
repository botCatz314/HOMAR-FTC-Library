package edu.spa.ftclib.internal.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Gabriel on 2017-12-27.
 * A four-wheel, standard Mecanum drivetrain.
 */

public class MecanumDrivetrain extends HolonomicFourWheelDrivetrain {

    /**
     *
     * @param motors the array of motors that you give the constructor so that it can find the hardware
     */
    public MecanumDrivetrain(DcMotor[] motors) {
        super(motors, new double[] {
                Math.PI/4, Math.PI/4, -Math.PI/4, -Math.PI/4 //the angles of the wheels on a mecanum drivetrain
        });
    }

    /**
     *
     * @param course the angle that you want the robot to move along
     * @param wheelAngle the array of angles that the actual moving parts of the wheels are at
     * @return a number between zero and one, which says what percentage of the speed a wheel should move at. Is then multiplied by the velocity
     */
    @Override
    double calculateWheelCoefficient(double course, double wheelAngle) {
        return Math.cos(course)-Math.sin(course)/Math.tan(wheelAngle); //fancy math that calculates the wheel coefficient
    }
}