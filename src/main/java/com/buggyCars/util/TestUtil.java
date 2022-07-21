package com.buggyCars.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static String login() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		String login = "test" + randomInt +"@gmail.com";
		return login;
	}

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/" + screenshotName + dateName + ".png"));
			System.out.println("ScreenShot Taken");
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());
		}
	}

}
