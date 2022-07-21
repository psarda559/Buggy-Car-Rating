package com.buggyCars.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.buggyCars.base.TestBase;
import com.buggyCars.pages.Homepage;
import com.buggyCars.pages.LoggedInPage;
import com.buggyCars.pages.ProfilePage;
import com.buggyCars.util.TestUtil;

public class Profile extends TestBase {
	Homepage homePage;
	LoggedInPage loggedInPage;
	ProfilePage profilePage;
	Login login;

	public Profile() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		profilePage = new ProfilePage();
	}

	@Test
	public void pwdRest() {
		String actualMsg = profilePage.changePassword();
		Assert.assertEquals(actualMsg, profilePage.successMsg);
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
