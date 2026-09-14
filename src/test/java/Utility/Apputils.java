package Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import PageObjectModule.Login_page;

public class Apputils {

    readconfig config = new readconfig();
    Baseclass util = new Baseclass();

    protected WebDriver driver;
    Login_page lp;

    @BeforeMethod
    @Parameters("Browser")
    
    public void LaunchApp(String Browser) {

        if (Browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (Browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            throw new IllegalArgumentException(
                "Browser not supported: " + Browser
            );
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get(config.Geturl());

        lp = new Login_page(driver);

        lp.UserEnterUsername();
        lp.userEnterpassword();
        lp.clickOnLogin();
    }

  @BeforeClass
	
	public void Beforeclassmethod(){
		System.out.println("Before class Executed");
	}
	
	
	@BeforeSuite
	public void BeforeSuitmehtod() {
		System.out.println("BeforSuiteRun");
	}

    @AfterMethod
    public void close(ITestResult sc) throws IOException {

        if (driver != null) {
            util.Screenshot(sc);
            driver.close();
        }
    }
}
