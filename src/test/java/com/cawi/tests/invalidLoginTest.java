package com.cawi.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cawi.generic.baseTest;
import com.cawi.generic.excelData;
import com.cawi.pages.loginPage;

public class invalidLoginTest extends baseTest
{
@Test(priority=1)
public void testInvalidLogin() throws InterruptedException

{
	
	Reporter.log("invalid test started",true);
	String user=excelData.getData(File_Path, "TC01", 1, 0);
	String pass=excelData.getData(File_Path, "TC01", 1, 1);
	String eTitle=excelData.getData(File_Path, "TC04", 1, 0);
	loginPage lp= new loginPage(driver);
	lp.verifyPage(eTitle);
	lp.clickLogo();
	new WebDriverWait(driver, 5);
	Thread.sleep(2000);
	Reporter.log("invalid user"+user, true);
	lp.enterUserName(user);
	new WebDriverWait(driver, 5);
	Thread.sleep(2000);
	Reporter.log("invalid password"+pass, true);
	lp.enterPassword(pass);
	Thread.sleep(2000);
    lp.clickOnLogin();	
	Reporter.log("This is a failed testcase of invalid login",true);
	Assert.fail();

}
}