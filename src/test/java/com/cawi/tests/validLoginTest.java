package com.cawi.tests;


import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.cawi.generic.baseTest;
import com.cawi.generic.excelData;
import com.cawi.pages.loginPage;
import com.cawi.generic.genericUtils;

public class validLoginTest extends baseTest
{

	@Test(priority=2)
	public void testValidLogin() throws InterruptedException
	{
		
		Reporter.log("valid test started",true);
		String user=excelData.getData(File_Path, "TC06", 1, 0);
		String pass=excelData.getData(File_Path, "TC06", 1, 1);
		String eTitle=excelData.getData(File_Path, "TC04", 1, 0);
		String leaveType = excelData.getData(File_Path, "TC07", 1, 0);
		String sessionType = excelData.getData(File_Path, "TC07", 0, 1);
		loginPage lp= new loginPage(driver);
		lp.verifyPage(eTitle);
		lp.clickLogo();
		Reporter.log("valid user"+user, true);
		lp.enterUserName(user);
		Reporter.log("valid password"+pass, true);
		lp.enterPassword(pass);
	    lp.clickOnLogin();
	    new WebDriverWait(driver, 5);
	    lp.clickOnViewLeaveBTN();
	    Thread.sleep(1000);
	    lp.verifyleave();
	    Thread.sleep(1000);
	    lp.clickGoBackBTN();
		Reporter.log("view leave balance successfull",true);
		new WebDriverWait(driver, 5);
		Thread.sleep(1000);
	    lp.clickViewGstnBTN();
		
	    Actions action = new Actions(driver);
	    Thread.sleep(2000);
		new WebDriverWait(driver, 5);

	    action.sendKeys(Keys.ESCAPE).build().perform();
	    lp.clickStrtOverBTN();
		Reporter.log("view gstn successfull",true);
		new WebDriverWait(driver, 5);
	    
		lp.clickApplyLeaveBTN();
	    new WebDriverWait(driver, 5);
	    Thread.sleep(2000);
	    genericUtils.selectByValue(lp.selectLeave(), leaveType);
	    new WebDriverWait(driver, 5);
	    Thread.sleep(1000);
	    genericUtils.selectByText(lp.selectSession(), sessionType);
	    Thread.sleep(1000);
	    lp.clickOndate();
	    Thread.sleep(1000);
	    lp.clickSelectDate();
	    Thread.sleep(1000);
	    lp.clickSend();
	    lp.clickStrtOverBTN();
	    Thread.sleep(2000);
		Reporter.log("apply leave working successfuly ", true);

	   
	}
	
}
