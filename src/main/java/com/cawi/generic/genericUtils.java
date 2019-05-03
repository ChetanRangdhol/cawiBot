package com.cawi.generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class genericUtils
{

	//This method is to capture the screenshot and return the path of the screenshot.
		public static String getscreenShot(WebDriver driver, String screenshotName) throws IOException 
		{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots" under src folder
	       String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		
	}
	public static void selectByValue(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public static void selectByText(WebElement element,String text)
	{
		Select sel=new Select (element);
		sel.selectByVisibleText(text);
	}
	public static List<String> getAllOptions(WebElement element)
	{
		ArrayList<String> alltext = new ArrayList<String>();
		Select sel = new Select(element);
		List<WebElement> allOptions = sel.getOptions();
		for (WebElement options:allOptions)
		{
			String text = options.getText();
			alltext.add(text);
		}
		return alltext;
	}

}
