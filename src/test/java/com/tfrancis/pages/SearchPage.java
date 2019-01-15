package com.tfrancis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickOnElement() {//button[contains(text(), 'Log in')];
		driver.get("https://www.linkedin.com/search/results/all/?keywords=university%20recruiter%20salesforce&origin=AUTO_COMPLETE&page=2");
		for(int i =0; i<5; i++) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("scroll(0, 250);");
//			driver.get("https://www.linkedin.com/search/results/all/?keywords=university%20recruiter%20salesforce&origin=AUTO_COMPLETE&page=2");
			WebElement connect = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Connect']")));
			connect.click();
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add a note']"))).click();
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='custom-message']"))).sendKeys("Hi,\r\n" + 
					"\r\n" + 
					"I am student at Santa Clara University pursuing MS in Computer Science. I am looking to extend my professional network to connect with right people, in my ongoing search for summer internship.\r\n" + 
					"\r\n" + 
					"Looking forward to connect with you, so I can share detailed work exp.\r\n" + 
					"\r\n" + 
					"Thank you,\r\n" + 
					"Thomas F\r\n" + 
					"");
			driver.findElement(By.xpath("//button[@class='button-primary-large ml1']")).click();
		}
	}
	
}
