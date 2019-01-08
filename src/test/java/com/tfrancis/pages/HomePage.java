package com.tfrancis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Using FindBy for locating elements
	@FindBy(how = How.XPATH, using = "//div[@id='userNavigationLabel']")
	WebElement profileDropdown;
	@FindBy(how = How.XPATH, using = "//text()[.='Log Out']/ancestor::span[1]")
	WebElement logoutLink;
	@FindBy(how = How.XPATH, using = "///div[text()='Good afternoon, SoftwareTesting!']")
	WebElement loggedInUserNameText;

	// Defining all the user actions (Methods) that can be performed in the Facebook
	// home page

	// This method to click on Profile Dropdown
	public void clickOnProfileDropdown() {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("userNavigationLabel")));
		profileDropdown.click();
	}

	// This method to click on Logout link
	public void clickOnLogoutLink() {
		logoutLink.click();
	}

	// This method to verify LoggedIn Username Text
	public String verifyLoggedInUserNameText() {
		String userName = loggedInUserNameText.getText();
		return userName;
	}
}
