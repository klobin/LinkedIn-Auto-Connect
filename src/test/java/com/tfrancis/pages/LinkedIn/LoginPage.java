package com.tfrancis.pages.LinkedIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@type='text'][@id='login-email']")
	WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='login-password']")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@id='login-submit']")
	WebElement submitButton;

	public void enterUserName(String username) {
		email.sendKeys(username);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickOnLogin() {
		submitButton.click();
	}
	
}
