package com.w3schools.utils;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sewrappers {


/*
 * This class is going to contain customized methods for all selenium default methods
 */


	
	public static WebDriver driver=null;
	
	
	//method to launch the chrome browser with the given url
	public void launchBrowser(String url)
	{
		try
		{
			driver= new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.println("Browser launched successfully");
			
			//to capture logs in the report
			Reports.reportStep("PASS","Chrome browser launched successfully");
			
		}
		catch(Exception ex)
		{
			
			Reports.reportStep("FAIL","Problem while launching the browser");

			//System.out.println("Problem while launching the browser");
			ex.printStackTrace();
			
		}
	}
	
	//method to close the current browser window
	public void closeCurrentBrowser()
	{
		try
		{
			driver.close();
			//System.out.println("Current browser window closed successfully");
			Reports.reportStep("PASS","Current browser window closed successfully");

			
		}
		catch(Exception ex)
		{
			//System.out.println("Problem while closing the current browser");
			Reports.reportStep("FAIL","Problem while closing the current browser");

			ex.printStackTrace();
		}
	}
	
	//method to close all the browsers
	public void closeAllBrowsers()
	{
		try
		{
			driver.quit();
			//System.out.println("All browsers closed successfully");
			Reports.reportStep("PASS","All browsers closed successfully");
		}
		catch(Exception ex)
		{
  			//System.out.println("Problem while closing the browsers");
			Reports.reportStep("FAIL","Problem while closing all the  browser");

  			ex.printStackTrace();
		}
	}
	
	//method to type text in the web page
	public void typeText(WebElement element, String text)
	{
		try
		{
			element.clear();
			element.sendKeys(text);
			
			Reports.reportStep("PASS","Typed the text "+text+" successfully");

		}
		catch(Exception ex)
		{
			//System.out.println("Problem while typing the text");
			Reports.reportStep("FAIL","Problem whle typing the "+text);
            ex.printStackTrace();
		}
	}
	
	//method to click on the webelement in the web page
	public void clickElement(WebElement ele)
	{
		try
		{
			ele.click();
			Reports.reportStep("PASS","Clicked the element sucessfully");

		}
		catch(Exception ex)
		{
			Reports.reportStep("PASS","Problem while Clicking the element");

			ex.printStackTrace();
		}
	}
	
	//Select dropdown - by Index
	
	public void selectByindex(WebElement ele, int index)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByIndex(index);
			Reports.reportStep("PASS","Selected the WebElement by Index Successfully");

			
		}
		catch(Exception ex)
		{
			Reports.reportStep("FAIL","Problem whilw Selecting  WebElement by Index ");

			ex.printStackTrace();
		}
	}
	

	//Select dropdown - By value
	
	public void selectByValue(WebElement ele, String value)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByValue(value);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//Select dropdown - By Visibletext
	
		public void selectByVisibleText(WebElement ele, String visibleText)
		{
			try
			{
				Select sel = new Select(ele);
				sel.selectByValue(visibleText);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		//Explicit wait
		
		public void WaitForElement(WebElement ele, int timeout)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
				wait.until(ExpectedConditions.visibilityOf(ele));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		
		
		}
		//fluent wait
		
		public void FluentWait(WebElement ele, int timeout)
		{
			try
			{
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						  .pollingEvery(Duration.ofSeconds(timeout))
						  .withTimeout(Duration.ofSeconds(timeout));
				
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("ele"))));

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
		
		
		//action class - click, doubliclick, contextclick, movetoElement, dragAndDrop
		
		//Click
		public void ActionClick(WebElement ele)
		{
			try
			{
				Actions action = new Actions(driver);
				action.click(ele).build().perform();
 
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		
		//DoubleClick
		public void DoubleClick(WebElement ele)
		{
			try
			{
			   Actions action = new Actions(driver);
               action.doubleClick(ele).build().perform();
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		//ContextClick
		
		public void ContextClick(WebElement ele)
		{
			try
			{
			   Actions action = new Actions(driver);
               action.contextClick(ele).build().perform();
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		//MoveToElement
		
		public void MoveToElement(WebElement ele)
		{
			try
			{
			   Actions action = new Actions(driver);
               action.moveToElement(ele).build().perform();
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		//dragAnddrop
		
		public void DragAndDrop(WebElement source, WebElement target)
		{
			try
			{
			   Actions action = new Actions(driver);
			   action.dragAndDrop(source,target).build().perform();

			}
			
			catch(Exception ex)
			
			{
				ex.printStackTrace();
			}
		}
		
		
		
		//frames
		
		//selectFrameByIndex
		
		public void FrameByIndex( int index)
		{
			try
			{
			  driver.switchTo().frame(index);
			}
			
			catch(Exception ex)
			{
			  ex.printStackTrace();	
			}
		}
		
		// ByNameorId
		
		public void FrameByNameorId( String nameid)
		{
			try
			{
			  driver.switchTo().frame(nameid);
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		//By WebElement
		
		public void FrameByWebElement(WebElement ele)
		{
			try
			{
			  driver.switchTo().frame(ele);
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		//Windowhandling --> 
		public void ParentWindow(WebElement ele, String ParentWindow)
		
		{
		  try
		  {
			  String parentWindow = driver.getWindowHandle();

			  Set<String> allWindows=driver.getWindowHandles();
				
				for(String eachWindow:allWindows)
				{
					
			    driver.switchTo().window(ParentWindow);
				}
		  }
		  
		  catch(Exception ex)
		  
		  {
			  ex.printStackTrace();
		  }
		}
		
		//windowHandles
		
       public void WindowHandles(WebElement ele, String ChildWindow)
		
		{
		  try
		  {
			 driver.switchTo().window(ChildWindow);
		  }
		  
		  catch(Exception ex)
		  
		  {
			  ex.printStackTrace();
		  }
		}
		
	    //JavascriptExecutor

      public void JavascriptExecutorScrollDown(int scrolldownValue)
     {
	   try
	  {
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//To ScrollDown
		js.executeScript("window.scrollBy(0,"+scrolldownValue+");");
	  }
	   catch(Exception ex)
	  {
		ex.printStackTrace();
	  }
   }

      public void JavascriptExecutorScrollUp(int scrollupValue)
    {
	  try
	  {
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//To ScrollDown
		js.executeScript("window.scrollBy("+scrollupValue+",0);");
	  }
	  catch(Exception ex)
	  {
		ex.printStackTrace();
	  }
  }
	
    public void JavascriptExecutorEndContent()
    {
	  try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//To ScrollDown to the End of the Content
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
  }

   public void JavascriptExecutorStartingContent()
  {
	try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//To ScrollUp to the Starting of the Content
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

   public void JavascriptExecutorScrollRight()
  {
	try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//To ScrollRight to the End of the Content
		js.executeScript("window.scrollTo(document.body.scrollWidth,0);");

	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

   public void JavascriptExecutorTitle()
  {
	try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//Getting the Title 
		System.out.print(js.executeScript("return document.title;"));

	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
  }

   public void JavascriptExecutorScrollWebElement(WebElement ele)
  {
	try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//to scroll until a particular webElement

		js.executeScript("arguments[0].scrollIntoView(true);",ele);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
  }


   public void JavascriptExecutorClickWebElement(WebElement ele)
  {
	try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//to click on a particular webElement

		js.executeScript("arguments[0].click();", ele);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}


  public void JavascriptExecutorTypeText(WebElement ele, String value)
  {
	try
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//type in text in a input box

		js.executeScript("arguments[0].value='"+value+"';", ele);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}


   public void acceptAlert()
{
	try
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}


   public void dismissAlert()
  {
	try
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

   public void typeInAlert(String value)
{
	try
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(value);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}


    public boolean verifySelected(WebElement ele)
 {
	boolean retVal=false;
	try
	{
		if(ele.isSelected())
		{
			retVal=true;
		}
	}
	catch(Exception ex)
	{
		
	}
	return retVal;
}


   public boolean verifyDisplayed(WebElement ele)
{
	boolean retVal=false;
	try
	{
		if(ele.isDisplayed())
		{
			retVal=true;
		}
	}
	catch(Exception ex)
	{
		
	}
	return retVal;
}

   public boolean verifyEnabled(WebElement ele)
{
	boolean retVal=false;
	try
	{
		if(ele.isEnabled())
		{
			retVal=true;
		}
	}
	catch(Exception ex)
	{
		
	}
	return retVal;
}
   
   
 //takes the screenshot of a specific page
 	public void CaptureScreenshot(String screenshotName)
 	{
 		try
 		{
 			File src=( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 			File dest= new File(System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png");
 			FileUtils.copyFile(src, dest);
 		}
 		catch(Exception ex)
 		{
 			ex.printStackTrace();
 		}
 		
 	}








		



}
