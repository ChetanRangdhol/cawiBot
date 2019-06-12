package com.cawi.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class baseTest implements AutoConstant
{
	public WebDriver driver;
	@BeforeMethod
	public void precondition()
	{
		System.setProperty(chrome_key,chrome_value);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://139.59.73.223:9004/your-bot/Luminous");
	}
	@AfterMethod
	public void postcondition(ITestResult res)
	{
		int status = res.getStatus();
		if(status==2)
		{
			String name =res.getName();
			Reporter.log("failed method "+name, true);
			genericUtils.getScreenShot(driver,name);
		}
		driver.quit();
	}
}

