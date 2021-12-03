package com.qa.facebookTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.facebook.BaseClass;
import com.qa.facebook.Util.Util;
import com.qa.facebook.pages.HomePage;
import com.qa.facebook.pages.LoginPage;

public class HomePageTest extends BaseClass {

	public HomePageTest() {
		super();

	}

	LoginPage login;
	HomePage home;

	@BeforeMethod
	public void SetUp() {
		initialization();
		login = new LoginPage();
		home = login.ValidateLogin(prop.getProperty("Email"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void VerifyUserNameLabelTest() {
		boolean b = home.VerifyUserNameLabel();
		assertEquals(b, true);
	}

	@Test(priority = 2)
	public void VerifyFriendsLinkTest() throws InterruptedException {

		home.VerifyFriendsLink();
//		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		driver.switchTo().alert().dismiss();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
