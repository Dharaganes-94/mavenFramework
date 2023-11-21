package com.w3schools.utils;

import org.openqa.selenium.support.PageFactory;

import com.w3schools.pages.LoginPage;

/*
 * This class is going to contain all the reusable methods from W3 schools application
 */


public class W3wrappers extends Sewrappers{

	 public void loginW3Schools()
	 {
		 LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		 loginpage.setUserName("dharani.gsd@gmail.com");
		 loginpage.setPassword("Dharaniganesan@994");
		 loginpage.clickLogin();
				 
	 }
}
