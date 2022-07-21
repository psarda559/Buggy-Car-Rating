package com.buggyCars.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buggyCars.base.TestBase;

public class Homepage extends TestBase {

	@FindBy(name = "login")
	WebElement login;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerBtn;

	@FindBy(xpath = "//a[@href='/make/c4u1mqnarscc72is00ng']")
	WebElement popularMakeLink;

	@FindBy(xpath = "//h2[text()=\"Popular Model\"]/following-sibling::a")
	WebElement popularModelLink;

	@FindBy(xpath = "//h2[text()=\"Overall Rating\"]/following-sibling::a")
	WebElement overallRatingLink;

	@FindBy(xpath = "//span[text()='Invalid username/password']")
	WebElement invalidUserMsg;

	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement logo;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public void loginWithRegisteredEmail(String username, String Password) {
		enterInput(login, username);
		enterInput(password, Password);
		clickOn(loginBtn);
	}

	public boolean invalidUser() {
		return invalidUserMsg.isDisplayed();
	}

	public boolean loginAvailable() {
		return loginBtn.isDisplayed();
	}

	public boolean navigatePopularMake() {
		clickOn(popularMakeLink);
		return driver.getCurrentUrl().contains("make");
	}

	public boolean navigatePopularModel() {
		clickOn(popularModelLink);
		return driver.getCurrentUrl().contains("model");
	}

	public boolean navigateOverallRating() {
		clickOn(overallRatingLink);
		return driver.getCurrentUrl().contains("overall");
	}
}
