package com.framework.utility;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	public static String CaptureScreenshots(WebDriver driver) {
		

	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir") + "/Screenshots/Orange_" + getcurrentdatetime() + ".png";
        
	File destination=new File(path);
	
	try {
	
	FileHandler.copy(source, destination);
	} 
	
	catch (IOException e) {
	
	System.out.println("Capture Failed"+e.getMessage());
		
    }
	return path; 

	}
	

	public static String getcurrentdatetime() {
		
		DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate=new Date();
		return customformat.format(currentdate);
	}
}
