package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import io.cucumber.java.Scenario;

public class Baseclass {
	WebDriver driver;
	
	public void dropdowntext(WebElement element, String text) {
		Select obj= new Select(element);
		obj.selectByVisibleText(text);
	}
	public void dropdownIndex(WebElement element, int number) {
	Select obj= new Select(element);
	obj.selectByIndex(number);
	}
	public void dropdownVisibleValue(WebElement element, String value) {
		Select obj= new Select(element);
		obj.selectByValue(value);
	}

	
	public void Screenshot( ITestResult result) throws IOException {
		   if (result.getStatus() == ITestResult.FAILURE) {

			String scenarioName= result.getName();
					System.out.println(scenarioName);
				
		String filename =scenarioName.replaceAll("[^a-zA-Z0-9]", "_");
		String uniquestring= new SimpleDateFormat("HH_mm_ss").format(new Date());
		
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File destfile= new File("D:\\Automation\\HybridFramework\\Screenshot\\"+filename+"_"+uniquestring+".png");
		FileUtils.copyFile(src, destfile);
	}
}}
