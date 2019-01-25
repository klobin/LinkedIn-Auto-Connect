package com.tfrancis.pages;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private static final String LINK = "https://www.linkedin.com/search/results/all/?keywords=University%20Recruiter%20at%20Salesforce&origin=GLOBAL_SEARCH_HEADER&page=";

	WebDriver driver;

	String name = "";
	String message = "" + "\r\n"
			+ "I am student at Santa Clara University pursuing MS in Computer Science. I am looking to extend my professional network to connect with right people, in my ongoing search for summer internship.\r\n"
			+ "\r\n" + "Looking forward to connect with you, so I can share detailed work exp.\r\n" + "\r\n"
			+ "Thank you,\r\n" + "Thomas F\r\n" + "";

	public SearchPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickOnElement() {
		Set<String> names = new HashSet<>();

		for (int j : IntStream.range(3, 6).boxed().collect(Collectors.toList())) {
			driver.navigate().to(LINK + j);
			try {
				while (checkIfElementIsPresent(driver, "//button[text()='Connect']")) {
					driver.navigate().to(LINK + j);
					WebElement connectButton = new WebDriverWait(driver, 10)
							.until(elementToBeClickable(xpath("//button[text()='Connect']")));
					new Actions(driver).moveToElement(connectButton);
					// WebElement connectButton =
					// driver.findElement(xpath("//button[text()='Connect']"));
					name = connectButton.getAttribute("aria-label").split(" ")[2];
					String temp = "Hi " + name + ",\r\n";

					// scroll to exact element
					scrollToElementByOffset(connectButton, -200).click();
//				(((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element));

					if (checkIfElementIsPresent(driver, "//input[@id='email']")) {
						driver.findElement(xpath("//input[@id='email']")).sendKeys("Thomas.A.francis@outlook.com");
					}

					new WebDriverWait(driver, 8).until(presenceOfElementLocated(xpath("//button[text()='Add a note']")))
							.click();

					driver.findElement(xpath("//textarea[@id='custom-message']")).sendKeys(temp + message);
					driver.findElement(xpath("//button[@class='button-primary-large ml1']")).click();
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				}
			} catch (NoSuchElementException e) {
				continue;
			}
		}

	}

	private WebElement scrollToElementByOffset(WebElement element, int offset) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(" + element.getLocation().getX() + ","
				+ (element.getLocation().getY() + offset) + ");");
		return element;
	}

	private boolean checkIfElementIsPresent(WebDriver driver, String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
