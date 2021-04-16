package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;

	
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
			
	}
	
	@FindBy(id="txtUsername") WebElement username;
	@FindBy(id="txtPassword") WebElement password;
	@FindBy(id="btnLogin") WebElement loginbutton;
	
	public void logintoOrange(String uname, String pass) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbutton.click();
		
		
	}
	
	
}
