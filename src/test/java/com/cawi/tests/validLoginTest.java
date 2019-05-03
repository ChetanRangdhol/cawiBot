package com.cawi.tests;


import org.testng.annotations.Test;

import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.cawi.generic.baseTest;
import com.cawi.generic.excelData;
import com.cawi.pages.clientsPage;
import com.cawi.pages.loginPage;

public class validLoginTest extends baseTest
{

	@Test(priority=2)
	public void testValidLogin()
	{
		ExtentTest logger= extent.createTest("test2 valid login");
		Reporter.log("valid test started",true);
		String user=excelData.getData(File_Path, "TC01", 1, 0);
		String pass=excelData.getData(File_Path, "TC01", 1, 1);
		String eTitle=excelData.getData(File_Path, "TC04", 1, 0);
		
		loginPage lp= new loginPage(driver);
		clientsPage cp=new clientsPage(driver);
		lp.verifyPage(eTitle);
		Reporter.log("valid user"+user, true);
		lp.enterUserName(user);
		Reporter.log("valid password"+pass, true);
		lp.enterPassword(pass);
	    lp.clickOnLogin();
	    cp.verifyClientModule();
	   
	}
	
}
