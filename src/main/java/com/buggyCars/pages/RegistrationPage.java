package com.buggyCars.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.buggyCars.base.TestBase;
import com.buggyCars.util.TestUtil;

public class RegistrationPage extends TestBase {

	public String login = TestUtil.login();
	public String registrationSuccessfulExpected = "Registration is successful";
	public String actual = "";

	@FindBy(xpath = "//a[@class='btn btn-success-outline']")
	WebElement registerButton;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement register;

	@FindBy(xpath = "//div[@class='result alert alert-success']")
	WebElement registrationSuccessmessage;

	@FindBy(xpath = "//a[text()=\"Profile\"]")
	WebElement profileLink;

	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	public void registration() {
		clickOn(registerButton);
		enterInput(username, login);
		enterInput(firstName, "First");
		enterInput(lastName, "Last");
		enterInput(passwordField, prop.getProperty("password"));
		enterInput(confirmPassword, prop.getProperty("password"));
		clickOn(register);
		waitForvisibility(registrationSuccessmessage);
		actual = getText(registrationSuccessmessage);
	}

}
