package com.tfrancis.base.login;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tfrancis.pages.LinkedIn.LoginPage;
import com.tfrancis.pages.home.HomePage;

public class LoginTest extends com.tfrancis.base.Test{
	
	@Test
	 public void init() throws Exception{
	 
	 LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	 loginpage.enterUserName("Thomas.A.Francis@outlook.com");
	 loginpage.enterPassword("@Klobin786");
	 loginpage.clickOnLogin();
	 }
	
	@Test
	public void searchRecruiter() throws InterruptedException {
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		homepage.search("technical recruiter");
		
		//homepage.clickUser();
	}
}
