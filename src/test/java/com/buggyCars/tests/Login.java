package com.buggyCars.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.buggyCars.base.TestBase;
import com.buggyCars.pages.Homepage;
import com.buggyCars.pages.LoggedInPage;
import com.buggyCars.util.TestUtil;

public class Login extends TestBase {
	Homepage homePage;
	LoggedInPage loggedInPage;

	public Login() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new Homepage();
		loggedInPage = new LoggedInPage();
	}

	@Test(priority = 1)
	public void invalidLogin() {
		homePage.loginWithRegisteredEmail("xyz", "123");
		Assert.assertTrue(homePage.invalidUser());
	}

	@Test(priority = 2)
	public void validLogin() {
		homePage.loginWithRegisteredEmail(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(loggedInPage.profileAvailable());
	}

	@Test(priority = 3)
	public void logout() {
		validLogin();
		loggedInPage.logoutUser();
		Assert.assertTrue(homePage.loginAvailable());
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
