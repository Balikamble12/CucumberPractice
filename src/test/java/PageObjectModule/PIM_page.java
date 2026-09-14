package PageObjectModule;

import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.CellValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Baseclass;
import Utility.Excel;

public class PIM_page {
	WebDriver driver;
	Excel XL= new Excel();
	String filepath="D:\\Backupp\\Automation Testing\\Excel data.xlsx";
	String Sheet = "sheet2";
	Baseclass util= new Baseclass();
	
	@FindBy(linkText = "PIM")
	WebElement PIM;
	@FindBy(id="empsearch_employee_name_empName")
	WebElement PIMEmpName;
	@FindBy(id="empsearch_id")
	WebElement PIMId;
	@FindBy(id="empsearch_employee_status")
	WebElement PIMEmpStatus;
	@FindBy(id="empsearch_termination")
	WebElement PIMInclue;
	@FindBy(id="empsearch_supervisor_name")
	WebElement PIMSupervisorName;
	@FindBy(id="empsearch_job_title")
	WebElement PIMJobtitle;
	@FindBy(id="searchBtn")
	WebElement PIMSearch;
	@FindBy(linkText = "0388")
	WebElement PIMRecord;
	
	
public PIM_page(WebDriver driver){
	this.driver= driver;	
	PageFactory.initElements(driver, this);
}
 public void UserClickOnPIM() {
	 PIM.click();
 }
 public void UserEnterempName() throws FileNotFoundException {
	 
	 PIMEmpName.sendKeys(XL.fetchExcelData(filepath, Sheet, 3, 1));
 }

 public void UserEnterPIMId() {
	 PIMId.sendKeys("101");
 }
 public void UserSelectempStatus() {
	util.dropdowntext(PIMEmpStatus, "FULL TIME"); 
 }
 public void UserSelectinclude() {
	 util.dropdowntext(PIMInclue, "Past Employees Only");
 }
 public void UserEnterSupervisorName() {
	PIMSupervisorName.sendKeys("demo");
 }
 public void UserEnterJobTitle() {
	 PIMJobtitle.sendKeys("Test Engineer");
 }
public void UserClickOnSearch() {
	PIMSearch.click();
}

}
