package com.framework.utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	public static WebDriver startapp(WebDriver driver,String browser_name, String app_URL) {
		
	
		
		if(browser_name.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		else if(browser_name.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
				
		}
		
		else if(browser_name.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
					
		}
		
		else
			
		System.out.println("Sorry we do not support your browser...");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(app_URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	

	
	public static void quitbrowser(WebDriver driver) {
		
		driver.quit();
		
	}
	
}
