package com.buggyCars.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buggyCars.base.TestBase;

public class LoggedInPage extends TestBase {

	@FindBy(xpath = "//a[text()=\"Profile\"]")
	WebElement profileLink;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutLink;

	public LoggedInPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean profileAvailable() {
		return profileLink.isDisplayed();
	}

	public void logoutUser() {
		clickOn(logoutLink);
	}
}
