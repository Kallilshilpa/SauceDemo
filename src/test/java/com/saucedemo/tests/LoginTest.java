package com.saucedemo.tests;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;

public class LoginTest extends BaseTest{
	LoginPage login;
	
	@DataProvider
	public String[][] getTestData() {
		XSSFSheet sheet = wb.getSheet("TC01");

		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[rows - 1][cells];

		/*
		 * Iterate through every cell in every row except the header row and store cell
		 * values in a 2D array
		 */
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				String cellData = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = cellData;
			}
		}
		return data;
	}

	
	@Test(dataProvider = "getTestData", priority = 1, description = "Validate user login for diff data set")
	public void loginTest(String username,String password) {
		login=new LoginPage(driver);
		System.out.println("Entering username: "+username);
		login.enterUsername(username);
		System.out.println("Entering password: "+password);
		login.enterPassword(password);
		System.out.println("Clicking login button");
		login.clickOnLoginBtn();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		String expUrl="https://www.saucedemo.com/inventory.html";
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expUrl,"The credentials are wrong" );
	}
}
