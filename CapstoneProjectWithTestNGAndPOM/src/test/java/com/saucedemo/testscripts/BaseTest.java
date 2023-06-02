package com.saucedemo.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	WebDriver driver;
	
	@BeforeClass
	public void launchApplication() {
		//1) Open browser and maximize it
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2) Navigate to application
		driver.get("https://saucedemo.com/");
	}
	
	@AfterClass
	public void closeBrowser() {
		// Close the browser.
		driver.quit();
	}

}
