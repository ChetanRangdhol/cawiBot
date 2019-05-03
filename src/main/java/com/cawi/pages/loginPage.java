
package com.cawi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cawi.generic.basePage;

public class loginPage extends basePage
{
	
	//declaration

		@FindBy(name="username")
		private WebElement usernameTB;
		
		@FindBy(name="password")
		private WebElement passwordTB;
		
		@FindBy(xpath="//button[.='LOGIN']")
		private WebElement loginBTN;
		
		@FindBy(xpath="//h5[.='Wrong Password']")
		private WebElement pwdErrorMSG;
		
		@FindBy(xpath="//button[.='OK']")
		private WebElement okBTN;
		
		@FindBy(xpath="//a[.='Forgot Password?']")
		private WebElement forgotPasswordBTN;
		
		@FindBy(xpath="//h5[.='User Not Found']")
		private WebElement userErrorMSG;
		
		@FindBy(name="userName")
		private WebElement frgtPassUsernameTB;
		
		@FindBy(xpath="//span[.='Continue']")
		private WebElement frgtPassContinueBTN;
	
		@FindBy(xpath="//span[.='Cancel']")
		private WebElement frgtPassCancelBTN;
		
		//initialization
		public loginPage(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(driver, this);	
		}
		// utilize
		public void verifyPage(String etitle)
		{
			verifyTitle(etitle);
		}
		public void enterUserName(String un) 
		{
		    usernameTB.sendKeys(un);	
		}
		public void enterPassword(String pw)
		{
			passwordTB.sendKeys(pw);
		}
		public String verifyPwdErrorMessage()
		{
			verifyElement(pwdErrorMSG);
		String aErrorMessage = pwdErrorMSG.getText();
		return aErrorMessage;	
		}
		public String verifyUserErrorMsg()
		{
			verifyElement(userErrorMSG);
		String aErrorMessage = userErrorMSG.getText();
		return aErrorMessage;
		}
		public void clickOnLogin() 
		{
		    loginBTN.click();	
		}
		public void clickOnOkBTN()
		{
			okBTN.click();
		}
		public void clickOnCancelBTN() 
		{
		frgtPassCancelBTN.click();	
		}
		public void clickOnContinueBTN() 
		{
		frgtPassContinueBTN.click();
		}
		public void frgtPassUserNameTB(String fun) 
		{
		frgtPassUsernameTB.sendKeys(fun);	
		}
		
		
		
		
		


}
