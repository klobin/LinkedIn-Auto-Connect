package com.tfrancis.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//artdeco-typeahead-deprecated-input[@id='ember43']//input[@placeholder='Search']")
	WebElement search;
	
	public void goToSearchPage() {
		driver.get("https://www.linkedin.com/search/results/people/?keywords=Technical%20Recruiter%20cisco&origin=GLOBAL_SEARCH_HEADER");
	}
	
	public void search(String searchString) throws InterruptedException {
//		search.sendKeys(searchString);
//		search.sendKeys(Keys.RETURN);
//		Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[5]/div[2]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]")).click();
//		driver.findElement(By.xpath("/html/body/div[5]/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/ul/li[1]/div/div/div[1]/a/figure/div/div/div/img")).click();
	}
}
