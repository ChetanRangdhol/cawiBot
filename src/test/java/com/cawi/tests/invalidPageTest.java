package com.cawi.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cawi.generic.baseTest;
import com.cawi.generic.excelData;
import com.cawi.pages.loginPage;

public class invalidPageTest extends baseTest

{
	@Test(priority=3)
	public void testInvalidPage() throws InterruptedException
	{
		
		Reporter.log("invalid page test started",true);
		String eTitle=excelData.getData(File_Path, "TC03", 1, 0);
		loginPage lp= new loginPage(driver);
		new WebDriverWait(driver, 5);
		lp.verifyPage(eTitle);
		new WebDriverWait(driver, 5);
		String atitle = driver.getTitle();
		Thread.sleep(1000);
		SoftAssert as=new SoftAssert();
		as.assertEquals(atitle, eTitle);
		Reporter.log("This test has failed",true);
		Reporter.log("---------------------------",true);
		
		
	}

}
