package com.buggyCars.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.buggyCars.base.TestBase;
import com.buggyCars.pages.RegistrationPage;
import com.buggyCars.util.TestUtil;

public class Registration extends TestBase {
	RegistrationPage registrationPage;

	public Registration() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		registrationPage = new RegistrationPage();
	}

	@Test
	public void registration() {
		registrationPage.registration();
		Assert.assertEquals(registrationPage.actual, registrationPage.registrationSuccessfulExpected);
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
