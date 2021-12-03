package com.qa.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.facebook.BaseClass;

public class LoginPage extends BaseClass{
	
	//PageFactory or Object Repository
	@FindBy(id="email")
	WebElement EmailID;
	
	@FindBy(name = "pass")
	WebElement Password;

	@FindBy(name="login")
	WebElement LogInBtn;
	
	@FindBy(xpath="//img[@class='fb_logo _8ilh img']")
	WebElement Logo;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateLogo() {
		return Logo.isDisplayed();
		
	}
	
	public HomePage ValidateLogin(String Un,String Pa) {
		EmailID.sendKeys(Un);
		Password.sendKeys(Pa);
		LogInBtn.click();
		return new HomePage();
		
	}
	
	
	
	
	
}
