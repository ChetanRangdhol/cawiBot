package com.cawi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cawi.generic.basePage;

public class clientsPage extends basePage
{

	@FindBy(xpath="//span[.='ADD NEW CLIENT']")
	private WebElement addClientBTN;
	
	@FindBy(xpath="//span[.='Clients']")
	private WebElement clientBTN;
    
	@FindBy(xpath="//span[.='Reports']")
    private WebElement reportsBTN;
    
	@FindBy(xpath="//span[.='Live Sessions']")
    private WebElement liveSessionBTN;
    
	@FindBy(xpath="//span[.='HR Reports']")
    private WebElement hrsessionBTN;
    
	@FindBy(xpath="//span[.='History']")
    private WebElement historyBTN;
    
	@FindBy(xpath="//span[.='INTENTS']")
    private WebElement intentBTN;
    
	@FindBy(xpath="//span[.='ENTITY']")
    private WebElement entityBTN;
    
	@FindBy(css="input[name='clientName']")
    private WebElement searchTB;
    
	@FindBy(xpath="//p[.='Clients']")
    private WebElement clientModule;
    
	@FindBy(xpath="//td[.='Robin']/../td[1]")
    private WebElement clientRobinID;
    
	@FindBy(xpath="//td[.='Robin']")
    private WebElement clientName;
	
	@FindBy(xpath="//button[@class='verticle-dots pull-right mat-icon-button']")
	private WebElement dotsBTN;
	
	@FindBy(xpath="//button[.='Logout']")
	private WebElement logoutBTN;
    
    // intiialization
	public clientsPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
    
	// utilization
	public void verifyPage(String etitle)
	{
	     verifyTitle(etitle);
	}
    
	public void verifyClientModule()
	{
		verifyElement(clientModule);
	}
	
	public void verifyClientBtn()
	{
		verifyElement(clientBTN);
	}
    
	public void verifyAddClientBTN() 
	{
	  
		verifyElement(addClientBTN);
	}
	public void verifyClientName() 
	{
	
		verifyElement(clientName);
	}
	
	public void verifyClientID() 
	{
		verifyElement(clientRobinID);
	}
	public void verifyEntityBTN()
	{
		verifyElement(entityBTN);
	}
	public void verifyIntentBTN() 
	{
		verifyElement(intentBTN);
	}
	public void verifySearchTB()
	{
		verifyElement(searchTB);
	}
	public void verifyReportsBTN()
	{
		verifyElement(reportsBTN);
	}
	public void verifyLiveSessionBTN()
	{
		verifyElement(liveSessionBTN);
	}
	public void verifyHrsessionBTN() 
	{
		verifyElement(hrsessionBTN);
	}
	public void verifyHistoryBTN()
	{
		verifyElement(historyBTN);
	}
	public String  SerchClientName(String CN)
	{
		searchTB.sendKeys(CN);
		verifyElement(clientName);
		String aClientName = clientName.getText();
      	return aClientName;
	}
	public void clickOnLogout()
	{
		 dotsBTN.click();
		 logoutBTN.click();
		
	}
	
}
