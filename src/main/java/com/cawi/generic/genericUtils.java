package com.cawi.generic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class genericUtils 
{

	public static void getScreenShot(WebDriver driver,String name)
	{
		try 
		{
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./screenshot/"+name+".png"));
		}
		catch (IOException e)
		{

		}
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
		List<String> alltext = new ArrayList<String>();
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
