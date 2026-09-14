package PageObjectModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.Baseclass;
import Utility.Apputils;


	public class Leave_page {
		WebDriver driver;
		Baseclass utils= new Baseclass();
		
		@FindBy(linkText = "Leave")
		WebElement leavebutton;
		
		@FindBy(className = "ui-datepicker-month")
		WebElement SelectMonth;
		
		@FindBy(className = "ui-datepicker-year")
		WebElement calyear;
		
		@FindBy(className = "ui-datepicker-calendar")
		WebElement Table;

		@FindBy(id = "calFromDate")
		WebElement CalenderLeaveStartDate;

		@FindBy(linkText = "Next")
		WebElement NextButton;

		
	  @FindBy(tagName = "tr")
		List<WebElement> rows;

		@FindBy(tagName = "td")
		List<WebElement> columns;
		
		@FindBy(id="calToDate")
		WebElement calenderleaveEndDateTtextbox;
		
		@FindBy(xpath = "//select[contains(@data-handler,\"selectMonth\")]")
		WebElement SelectLeaveEndMonthDate;

		@FindBy(xpath = "//input[@type=\"checkbox\"][4]")
		WebElement pendingApprovalcheckbox;
		
		@FindBy(xpath = "//input[@type=\"checkbox\"][2]")
		WebElement RejectedCheckbox;
		
		@FindBy(id="leaveList_txtEmployee_empName")
		WebElement LeaveEmpName;
		
		@FindBy(id="leaveList_cmbWithTerminated")
		WebElement includePastEmpCheckbox;
		
		public Leave_page(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		

		public void UserClickOnLeave() {
			leavebutton.click();
		}

		public void userSelectStartLeaveDate() throws InterruptedException {
		CalenderLeaveStartDate.click();
		
       utils.dropdowntext(SelectMonth, "Oct");
		
       utils.dropdowntext(calyear, "2028");
		
		WebElement entireTable= Table;
		List<WebElement> rows= entireTable.findElements(By.tagName("tr"));
		
		for(int i=1; i<rows.size(); i++)
		{
			List<WebElement> columns= rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0; j<columns.size(); j++)
			{
				String dt=columns.get(j).getText();
				
				if(dt.equals("18"))
				{
					columns.get(i).click();
					Thread.sleep(2000);
				}
			}
			}
		}
		
		
		
		
		
		public void userSelectEndLeaveDate() throws InterruptedException {
			Thread.sleep(2000);
			calenderleaveEndDateTtextbox.click();
			utils.dropdowntext(calyear, "2029");
			utils.dropdowntext(SelectLeaveEndMonthDate, "Oct");
		
		
		WebElement table= Table;
		List<WebElement> rows= Table.findElements(By.tagName("tr"));
		
		for(int i=1; i<rows.size(); i++)
		{
			List<WebElement> columns= rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0; j<columns.size(); j++)
			{
				String columntext= columns.get(j).getText();
				if(columntext.equals("25")) {
					columns.get(j).click();
					Thread.sleep(2000);
				}
			}
		}}	
		
		public void ValidateOfPendingApprovalcheckbox() throws InterruptedException {
			Assert.assertTrue(pendingApprovalcheckbox.isSelected());
			System.out.println("yes it is alrady selected");
			
			pendingApprovalcheckbox.click();
			Thread.sleep(2000);
			
	}
		
		public void clickOnRejectedStatus() throws InterruptedException {
			RejectedCheckbox.click();
			Thread.sleep(2000);
		}
		public void UserSelectLeaveEmpName() throws InterruptedException {
		LeaveEmpName.sendKeys("test users");
		Thread.sleep(2000);
	
		}
		
		public void ClickOnPastEmployees() throws InterruptedException {
			Thread.sleep(2000);
			includePastEmpCheckbox.click();
		}
		
	}



