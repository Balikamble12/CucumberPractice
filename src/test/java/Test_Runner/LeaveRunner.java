package Test_Runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjectModule.Leave_page;
import PageObjectModule.Login_page;
import Utility.Apputils;


public class LeaveRunner extends Apputils {
	
	
	Leave_page lm;
	
	@BeforeMethod

	public void driverinit() {
		lm=new Leave_page(driver);
	}
	@Test(priority=1)

	public void Leave_functionlity() throws InterruptedException {
		
	lm.UserClickOnLeave();
	lm.userSelectStartLeaveDate();
	lm.userSelectEndLeaveDate();
	lm.ValidateOfPendingApprovalcheckbox();
	lm.clickOnRejectedStatus();
	lm.UserSelectLeaveEmpName();
	lm.ClickOnPastEmployees();
	System.out.println("Leaverunner run priority =1");
	}
	
	
	
	
}
