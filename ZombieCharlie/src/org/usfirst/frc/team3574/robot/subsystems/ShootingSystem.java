package org.usfirst.frc.team3574.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3574.robot.RobotMap;
import com.ctre.CANTalon;
import com.ctre.PigeonImu.CalibrationMode;

/**
 *
 */
public class ShootingSystem extends Subsystem {
	CANTalon belt = RobotMap.conveyorBelt;
	CANTalon shooter = RobotMap.shooter;
	// Put methods for controlling this subsystem
	// here. Call these from Command
	public ShootingSystem (){
		belt.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		belt.reverseSensor(true);
	
		belt.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
//		belt.changeControlMode(CANTalon.TalonControlMode.Position);
////		belt.set(0);
//		belt.setPID(.5, 0, 0);
//		belt.enable();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void drive(double speed) {
		belt.set(speed);
	}
	
	public void resetDrive() {
		belt.reset();
	}

	public void fire() {
		shooter.set(-.55);
	}

	public void stopDrive() {
		belt.set(0);
	}

	public void stopFire() {
		shooter.set(0);
	}
	
	public double encoderValue(){
		return belt.getEncPosition();
	}
	
	public void log(){
		SmartDashboard.putNumber("Encoder", encoderValue());
	}
}
