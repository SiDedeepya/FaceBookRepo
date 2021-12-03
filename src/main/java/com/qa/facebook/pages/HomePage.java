package com.qa.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.facebook.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'and contains(text(),'Dedeepya')]")
	WebElement UserNameLabel;
	
	@FindBy(xpath="//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7'and contains(text(),'Friends')]")
	WebElement FriendsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyUserNameLabel() {
		return UserNameLabel.isDisplayed();
	}
	
	public FriendsPage VerifyFriendsLink() {
		FriendsLink.click();
		return new FriendsPage();
	}

}
