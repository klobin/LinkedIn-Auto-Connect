package com.tfrancis.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagingPage {

	WebDriver driver;

	public MessagingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}//

	public void sendReply() {
		driver.get("https://www.linkedin.com/messaging/thread/6490710264525258752/");
		WebElement attachment = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='msg-form__footer-action button-tertiary-medium-round-muted m0' and @id='attachment-trigger-ember3920']")));
		attachment.sendKeys("D:\\Santa Clara University\\Resume");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		WebElement textArea = driver.findElement(By.xpath("//div[@class='msg-form__contenteditable t-14 t-black--light t-normal flex-grow-1']"));
//		textArea.sendKeys("ABC");
		//driver.findElement(By.xpath("//*[@id=\"attachment-trigger-ember1000\"]")).click();
//		WebElement attachment = driver.findElement(By.xpath("//input[@id='attachment-input-ember1000']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
