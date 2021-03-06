package com.tfrancis.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagingPage {

	WebDriver driver;

	public MessagingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void sendReply() {
		driver.get("https://www.linkedin.com/messaging/thread/6490710264525258752/");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement area = driver.findElement(By.xpath("//div[@class='msg-form__contenteditable t-14 t-black--light t-normal flex-grow-1']"));
		area.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('ember1160').focus();");
		WebElement textArea = area.findElement(By.tagName("p"));
		textArea.click();
		textArea.sendKeys(new String[] {"Hi"});
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"attachment-trigger-ember1000\"]")))).sendKeys("D:\\SantaClaraUniversity\\Resume");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
