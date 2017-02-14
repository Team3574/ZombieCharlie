package org.usfirst.frc.team3574.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3574.robot.OI;
import org.usfirst.frc.team3574.robot.Robot;

/**
 *
 */
public class Convey extends Command {
	OI oI = Robot.oi;
	
	double throttle;
	
	/**
	 * Convey does some interesting things
	 */
	public Convey() {
		// Use requires() here to declare subsystem dependencies
	
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
//		Robot.exampleSubsystem.drive();
		SmartDashboard.putNumber("encPosition", 0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putNumber("theValue", 
				SmartDashboard.getNumber("encPosition", 0));
		Robot.ShootingSystem.drive(Robot.oi.YValue());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.ShootingSystem.stopDrive();
	}
}
