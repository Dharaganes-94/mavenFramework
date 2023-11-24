package com.w3schools.tests;
/*
 * This class is going to contain all the test cases with regard to Login functionality in W3schools
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w3schools.utils.Reports;
import com.w3schools.utils.Sewrappers;
import com.w3schools.utils.W3wrappers;

public class LoginTest extends Sewrappers {
	W3wrappers w3= new W3wrappers();
	Reports report = new Reports();
	
	@Test
	public void loginWithValidCredentials()
	{
		try
		{
			report.setTCDesc("Validating login in W3 schools with valid credentials");
			launchBrowser("https://profile.w3schools.com/");
			w3.loginW3Schools("dharani.gsd@gmail.com","Dharaniganesan@994");
						
			//validation for checking the title
			Assert.assertTrue(driver.getTitle().equals("My learning | W3Schools"));
			System.out.println("Assertion Passed");
			Reports.reportStep("INFO","Assertion passed by title");
			
			//To Enter into Profile element in HomePge
			//w3.pageProfile("estoyVignesh1");
			
					
		}
		
		
		catch(Exception ex)
		{
			System.out.println("Problem while logging with valid credentials");
			ex.printStackTrace();
			
		}
	}

}