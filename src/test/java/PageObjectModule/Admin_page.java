package PageObjectModule;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.Apputils;
import Utility.Baseclass;
import Utility.readconfig;

public class Admin_page {

	WebDriver driver;
	Baseclass util= new Baseclass();
	readconfig config = new readconfig();

	@FindBy(id ="menu_admin_viewAdminModule")
	WebElement AdminButton;
	
	@FindBy(id="searchSystemUser_userName")
	WebElement AdminUserName;

	@FindBy(id = "searchSystemUser_userType")
	WebElement Adminuserrole;

	@FindBy(id = "searchSystemUser_employeeName_empName")
	WebElement AdminempName;

	@FindBy(id = "searchSystemUser_status")
	WebElement AdminUserstatus;

	@FindBy(id = "searchBtn")
	WebElement AdminSearhButton;

	@FindBy(xpath = "//td[contains(text(),'No Records Found')]")
	WebElement HandleNotFoundRecord;

	@FindBy(xpath = "//a[contains(text(),'Admin')]")
	WebElement AdminRecord;
	
	


	public Admin_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void userClickOnAdminButton() throws InterruptedException {
	AdminButton.click();
		
	}

	public void UserEnterAdminUserName() throws InterruptedException {
		AdminUserName.sendKeys("Admin");
	}

	public void userSelectUserRole() {
   util.dropdowntext(Adminuserrole, "Admin");
	}

	public void userEnterEmpName() {
		AdminempName.sendKeys("Suresh Babu");

	}

	public void UserSelectStatus() throws InterruptedException {
		
		util.dropdowntext(AdminUserstatus,"Enabled" );

	}

	public void UserClickOnSearch() throws InterruptedException {
		Thread.sleep(4000);
		AdminSearhButton.click();
	
	}

	public void userValidateaAdminRecord() {

		String text = AdminRecord.getText();

		System.out.println( "i found record as "+ text);
		
		
	}

	public void UserClearAdminUsername() {
		
		AdminUserName.clear();
	
}
	public void UserValidateUsernameblank() {
		String text= AdminUserName.getText();
		Assert.assertEquals(text, "");	
	}
	

}


