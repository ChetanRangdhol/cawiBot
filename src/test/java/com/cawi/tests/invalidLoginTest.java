package com.cawi.tests;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.Reporter;


import com.cawi.generic.baseTest;
import com.cawi.generic.excelData;
import com.cawi.pages.loginPage;

public class invalidLoginTest extends baseTest
{
@Test(priority=1)
	public void testInvalidLoginLogout() throws InterruptedException 
	{
	
	Reporter.log("invalid test started",true);
	String loginTitle=excelData.getData(File_Path, "TC04", 1, 0);
	String expecteduserErrorMessage=excelData.getData(File_Path, "TC05", 1, 0);
	String expectedPwdErrorMessage=excelData.getData(File_Path, "TC05", 2,0 );
	loginPage lp=new loginPage(driver);
	
	//verify login page
	lp.verifyPage(loginTitle);
	String username = excelData.getData(File_Path, "TC02", 1, 0);
	String password=excelData.getData(File_Path, "TC02", 1, 1);
	Reporter.log("invalid user"+username, true);
	lp.enterUserName(username);
//enter invalid pass
	Reporter.log("invalid pass"+password, true);
	lp.enterPassword(password);
// click login
	lp.clickOnLogin();
	
// verify error msg
	String actualErrorMsg = lp.verifyPwdErrorMessage();
	Reporter.log("actual Error Message"+actualErrorMsg, true);
	Reporter.log("expected error message"+expectedPwdErrorMessage, true);
	lp.clickOnOkBTN();
	Thread.sleep(2000);
	Assert.assertEquals(actualErrorMsg, expectedPwdErrorMessage);
	
	int rc= excelData.getRowCount(File_Path, "TC06");
	for(int i =1;i<=rc;i++)
	{
		String user = excelData.getData(File_Path, "TC06", i, 0);
		String pass=excelData.getData(File_Path, "TC06", i, 1);
	//enter invalid user name 
		Reporter.log("invalid user"+user, true);
		lp.enterUserName(user);
	//enter invalid pass
		Reporter.log("invalid pass"+pass, true);
		lp.enterPassword(pass);
	// click login
		lp.clickOnLogin();
		Thread.sleep(1000);
	// verify error msg
		String actualUserErrorMsg = lp.verifyUserErrorMsg();
		Reporter.log("actual Error Message"+actualUserErrorMsg, true);
		Reporter.log("expected error message"+expecteduserErrorMessage, true);
		Assert.assertEquals(actualUserErrorMsg, expecteduserErrorMessage);
		Reporter.log("error msg is matching", true);
		Reporter.log("=====================", true);
		lp.clickOnOkBTN();
	}
		
	}
}
