package com.buggyCars.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.buggyCars.base.TestBase;
import com.buggyCars.pages.Homepage;
import com.buggyCars.pages.OverallRatingPage;
import com.buggyCars.util.TestUtil;

public class VoteWithoutLogin extends TestBase {
	Homepage homePage;
	OverallRatingPage overallRatingPage;

	public VoteWithoutLogin() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new Homepage();
		overallRatingPage = new OverallRatingPage();
	}

	@Test
	public void invalidVote() {
		homePage.navigateOverallRating();
		Assert.assertTrue(overallRatingPage.tryToVote());
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
