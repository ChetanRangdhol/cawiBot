
package com.cawi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cawi.generic.basePage;

public class loginPage extends basePage
{
	
	//declaration
	
	    
	
	    @FindBy(xpath="//img[@src='http://139.59.73.223:9006/uploads/logos/91248be0-4620-11e9-b98d-6d33db91c1f0launchIcon.png']")
        private WebElement 	logo;	
		
        @FindBy(name="employeeID")
		private WebElement usernameTB;
		
		@FindBy(name="employeePwd")
		private WebElement passwordTB;
		
		@FindBy(xpath="//button[.='Start Conversation']")
		private WebElement loginBTN;
		
		@FindBy(xpath="(//button[.=' 1. View leave balance '])[last()]")
		private WebElement ViewLeaveBTN;
		
		@FindBy(xpath="//label[.='View Leave Balance']")
		private WebElement ViewLeaveTitle;
		
		@FindBy(xpath="(//button[.=' 4. View GSTN '])[last()]")
		private WebElement ViewGstnBTN;
		
		@FindBy(xpath="(//button[.=' 9. Apply Leave '])[last()]")
		private WebElement applyLeaveBTN;
		
		@FindBy(xpath="(//button[.=' Go back '])[last()]")
		private WebElement GoBackBTN;
		
		@FindBy(className="img close-embed")
		private WebElement ClosePopUpBTN;
		
		@FindBy(xpath="(//button[.='Start Over '])[last()]")
		private WebElement startOverBTN;
		
		@FindBy(xpath="//td[.='25']")
		private WebElement selectDate;
		
		@FindBy(name="date")
		private WebElement date;
		
		@FindBy(name="applicationType")
		private WebElement leaveType;
		
		@FindBy(css="select[name='sessionType']")
		private WebElement sessionType;
		
		@FindBy(xpath="//button[.='Send ']")
		private WebElement sendBTN;
		
		
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
		public void clickGoBackBTN()
		{
			GoBackBTN.click();
		}
		public void clickStrtOverBTN()
		{
			startOverBTN.click();
		}
		public void clickOnViewLeaveBTN()
		{
		   ViewLeaveBTN.click();
		}
		public void clickViewGstnBTN()
		{
			ViewGstnBTN.click();
			
		}
		public String verifyleave()
		{
			verifyElement(ViewLeaveTitle);
			String vl=ViewLeaveTitle.getText();
			return vl;
		}
		public void clickClosePopUp()
		{
			ClosePopUpBTN.click();
		}
		public void clickApplyLeaveBTN()
		{
			applyLeaveBTN.click();
		}
		public void clickOnLogin() 
		{
		    loginBTN.click();	
		}
		
		public void clickOndate()
		{
			date.click();
		}
		 public void clickSend()
		 {
			 sendBTN.click();
		 }
		 public WebElement selectLeave()
		 {
			 
			 return leaveType;
		 }

		 public WebElement selectSession()
		 {
			 return sessionType;
		 }
		 
		 public void clickSelectDate()
		 {
			 selectDate.click();
		 }

		 public void clickLogo()
		 {
			 logo.click();
		 }
}
