package com.tfrancis.base.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tfrancis.pages.home.HomePage;

public class HomePageTest {

	WebDriver driver;
	
	@Test
	 public void init() throws Exception{
	 HomePage homepage = PageFactory.initElements(driver, HomePage.class);
	}

}
