package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {

	
	public static String generateRandomString(int length, boolean useLetters,boolean useNumbers ) {
		
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

	    return generatedString;
	}
	
	public static String captureScreenshot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				System.getProperty("user.dir") + "/screenshots/saucedemo" + System.currentTimeMillis() + ".png");

		String absolutePath = dest.getAbsolutePath();

		try {
			FileUtils.copyFile(src, dest);
			System.out.println("Screenshot captured!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return absolutePath;

	}
}
