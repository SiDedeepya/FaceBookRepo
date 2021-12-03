package com.qa.facebookTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.facebook.BaseClass;
import com.qa.facebook.pages.HomePage;
import com.qa.facebook.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	public LoginPageTest() {
		super();
	}

	LoginPage login;
	HomePage home;

	@BeforeMethod
	public void SetUp() {
		initialization();
		login = new LoginPage();
	}

	@Test(priority = 1)
	public void ValidatePageTitleTest() {
		String str = login.ValidatePageTitle();
		assertEquals("Facebook – log in or sign up", str);
	}

	@Test(priority = 2)
	public void ValidateLogoTest() {
		boolean b = login.ValidateLogo();
		assertTrue(b);
	}

	@Test(priority = 3)
	public void ValidateLoginTest() {
		home = login.ValidateLogin(prop.getProperty("Email"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
