package com.framework.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.utility.BrowserFactory;
import com.framework.utility.ConfigDataProvider;
import com.framework.utility.ExcelDataProvider;
import com.framework.utility.Helper;

public class BaseClass {
	
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupsuite() {
	excel= new ExcelDataProvider();
	config=new ConfigDataProvider();
	ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/Orangelive_"+Helper.getcurrentdatetime()+".html"));
	report=new ExtentReports();
	report.attachReporter(extent);
	logger=report.createTest("Login to Orange");
	}
	

	@BeforeClass
	public void setup() {
		
	driver=BrowserFactory.startapp(driver, config.getbrowser(), config.getURL());
	
	}

	@AfterClass
	public void teardown() {
	
	BrowserFactory.quitbrowser(driver);
	
	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException{
		
		
		
		if(result.getStatus()==ITestResult.FAILURE) {
		
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshots(driver)).build());
			}
		
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshots(driver)).build());
		}
		
		
		report.flush();
		
		
	}

}
