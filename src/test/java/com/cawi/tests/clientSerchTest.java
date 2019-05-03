package com.cawi.tests;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.Reporter;

import com.cawi.generic.baseTest;
import com.cawi.generic.excelData;
import com.cawi.pages.clientsPage;
import com.cawi.pages.loginPage;

public class clientSerchTest extends baseTest
{
	@Test(priority=3)
	public void testSerchEngine()
	{
		
		Reporter.log("client serch test started",true);
		String eClient=excelData.getData(File_Path, "TC03", 1, 0);
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
	    cp.verifySearchTB();
	    String actualClient = cp.SerchClientName(eClient);
	    Reporter.log("actual client name"+actualClient, true);
		Reporter.log("expected client name"+eClient, true);
		Assert.assertEquals(actualClient, eClient);
		Reporter.log("client names are matching", true);
		Reporter.log("=====================", true);
		
		
		
		
	}

	
	
	
}
