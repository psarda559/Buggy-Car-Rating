package com.buggyCars.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.buggyCars.base.TestBase;

public class OverallRatingPage extends TestBase {

	String countBeforeVote;
	String countAfterVote;
	LoggedInPage lp = new LoggedInPage();
	RegistrationPage regPage = new RegistrationPage();
	Homepage hp = new Homepage();

	@FindBy(xpath = "(//a[text()=\"View more\"])[1]")
	WebElement viewMore;

	@FindBy(xpath = "//p[@class='card-text']")
	WebElement voteMsg;

	@FindBy(xpath = "//button[text()='Vote!']")
	WebElement voteBtn;

	@FindBy(xpath = "//textarea[@id='comment']")
	WebElement commentBox;

	@FindBy(xpath = "//div[@class='card-block']/h4/strong")
	WebElement votesCount;

	@FindBy(xpath = "//table/tbody/tr[1]/td[3]")
	WebElement commentUpdated;

	@FindBy(xpath = "(//div[@class='card-block'])[4]")
	WebElement msgAfterVote;

	@FindBy(xpath = "(//div[@class='row'][1])[2]")
	WebElement row;

	public OverallRatingPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean tryToVote() {
		clickOn(viewMore);
		return getText(voteMsg).equalsIgnoreCase("You need to be logged in to vote.");
	}

	public boolean vote() {
		clickOn(viewMore);
		boolean voteCountCheck = false;

		// If user has already voted, then register a new user to perform vote!

		if ((getText(row).contains("Thank you for your vote!"))) {
			lp.logoutUser();
			registrationAndLogin();
			clickOn(hp.logo);
			hp.navigateOverallRating();
			clickOn(viewMore);
			voteCountCheck = voteWithComment();
		} else {
			voteCountCheck = voteWithComment();
		}
		return voteCountCheck;
	}

	public boolean voteWithComment() {
		countBeforeVote = getText(votesCount);
		enterInput(commentBox, "This is test comment");
		clickOn(voteBtn);
		waitForInvisibility(voteBtn);
		countAfterVote = getText(votesCount);
		int countBefore = Integer.parseInt(countBeforeVote);
		int countAfter = Integer.parseInt(countAfterVote);
		boolean b = ((countAfter - countBefore) == 1);
		return b;
	}

	public boolean cnfMsgAfterVote() {
		if (getText(msgAfterVote).equals("Thank you for your vote!")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean cnfcommentUpdated() {
		if (getText(commentUpdated).equals("This is test comment")) {
			return true;
		} else {
			return false;
		}
	}

	public void registrationAndLogin() {
		regPage.registration();
		waitForClickability(hp.loginBtn);
		Homepage hp = new Homepage();
		hp.loginWithRegisteredEmail(regPage.login, prop.getProperty("password"));
	}
}
