package com.buggyCars.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.buggyCars.base.TestBase;

public class ProfilePage extends TestBase {

	public String successMsg = "The profile has been saved successful";
	OverallRatingPage orp = new OverallRatingPage();
	LoggedInPage lp = new LoggedInPage();

	@FindBy(name = "currentPassword")
	WebElement currentPassword;

	@FindBy(name = "newPassword")
	WebElement newPassword;

	@FindBy(name = "newPasswordConfirmation")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='result alert alert-success hidden-md-down']")
	WebElement profileChangeSuccessMsg;

	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public String changePassword() {
		orp.registrationAndLogin();
		clickOn(lp.profileLink);
		enterInput(currentPassword, prop.getProperty("password"));
		enterInput(newPassword, prop.getProperty("tempPassword"));
		enterInput(confirmPassword, prop.getProperty("tempPassword"));
		clickOn(saveBtn);
		waitForvisibility(profileChangeSuccessMsg);
		return getText(profileChangeSuccessMsg);
	}
}