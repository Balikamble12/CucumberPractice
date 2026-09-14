package Test_Runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObjectModule.Admin_page;
import PageObjectModule.Leave_page;
import PageObjectModule.Login_page;
import Utility.Apputils;

public class AdminRunner extends Apputils {
	
	 Admin_page ad;
	 
	 @BeforeMethod
	  public void initPage() {
	   ad = new Admin_page(driver);  // driver is already initialized in Baseclass
	    }
	 
	@Test(priority=2)
	public void ValidateAdminFunctionlity() throws InterruptedException {
		
		ad.userClickOnAdminButton();
		ad.UserEnterAdminUserName();
		ad.userSelectUserRole();
		ad.userEnterEmpName();
		ad.UserSelectStatus();
		ad.UserClickOnSearch();
		ad.userValidateaAdminRecord();
		System.out.println("adminrunner run priority =2");}
		
		
	@Test
public void UservalidateusernameClear() throws InterruptedException {
ad.userClickOnAdminButton();
ad.UserEnterAdminUserName();
ad.UserClearAdminUsername();
ad.UserValidateUsernameblank();
	
}
	
}
