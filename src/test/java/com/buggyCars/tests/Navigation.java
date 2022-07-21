package com.buggyCars.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.buggyCars.base.TestBase;
import com.buggyCars.pages.Homepage;
import com.buggyCars.util.TestUtil;

public class Navigation extends TestBase {
	Homepage homePage;

	public Navigation() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new Homepage();
	}

	@Test
	public void popularMakeNavigation() {
		Assert.assertTrue(homePage.navigatePopularMake());
	}

	@Test
	public void popularModelNavigation() {
		Assert.assertTrue(homePage.navigatePopularModel());
	}

	@Test
	public void overallRatingNavigation() {
		Assert.assertTrue(homePage.navigateOverallRating());
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
