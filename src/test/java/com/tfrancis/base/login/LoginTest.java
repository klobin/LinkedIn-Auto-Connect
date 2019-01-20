package com.tfrancis.base.login;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tfrancis.pages.MessagingPage;
import com.tfrancis.pages.SearchPage;
import com.tfrancis.pages.LinkedIn.LoginPage;
import com.tfrancis.pages.home.HomePage;

public class LoginTest extends com.tfrancis.base.Test{

	@Test(enabled = false)
	 public void init() throws Exception{
	 LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	 loginpage.enterUserName("Thomas.A.Francis@outlook.com");
	 loginpage.enterPassword("***********");
	 loginpage.clickOnLogin();
	 }
	
	
	@Test(invocationCount = 1)
	public void searchRecruiter() throws Exception {
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		init();
//		homepage.goToSearchPage();
		SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
		searchPage.clickOnElement();
	}
	
	@Test
	public void replyBack() throws Exception {
		init();
		MessagingPage messagingPage = PageFactory.initElements(driver, MessagingPage.class);
		messagingPage.sendReply();
	}
}
