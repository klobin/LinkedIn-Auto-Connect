package com.tfrancis.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Test {
	public static WebDriver driver = null;
	 
	 @BeforeSuite
	 public void initialize() throws IOException{
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
	 
	 driver = new ChromeDriver(); 
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	         driver.get("https://www.linkedin.com");
	 }
	 
	 @AfterSuite
	 //Test cleanup
	 public void TeardownTest()
	    {
		 Test.driver.quit();
	    }
}
