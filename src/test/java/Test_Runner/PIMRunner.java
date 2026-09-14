package Test_Runner;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjectModule.PIM_page;
import Utility.Apputils;

public class PIMRunner extends Apputils {
	
	PIM_page pm;
	
	@BeforeMethod
	public void driversetup(){
		pm= new PIM_page(driver);
	}

	@Test(priority=3)
	public void ValidatePIMfunctionlity() throws FileNotFoundException {
		
	pm.UserClickOnPIM();
	pm.UserEnterempName();
	pm.UserEnterPIMId();
	pm.UserSelectempStatus();
	pm.UserSelectinclude();
	pm.UserEnterSupervisorName();
	pm.UserEnterJobTitle();
	pm.UserClickOnSearch();
	System.out.println("PIMrunner run priority=3");
	}
}
