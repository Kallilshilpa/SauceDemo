package com.saucedemo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.saucedemo.utils.TestUtils;

public class BaseTest {
	
	public WebDriver driver;
	Properties prop;
	public XSSFWorkbook wb;

	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/saucedemo/config/config.properties");
			File src = new File(System.getProperty("user.dir") + "/src/test/java/com/saucedemo/testdata/TestData.xlsx");
			prop.load(ip);
			FileInputStream file = new FileInputStream(src);
			wb = new XSSFWorkbook(file);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void initialization() {
		System.out.println("opening browser and navigating to application");
		if(prop.getProperty("browser").equals("chrome")) {
			System.out.println("initializing chrome browser...");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")) {
			System.out.println("initializing firefox browser...");
			driver=new FirefoxDriver();
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("Opening "+prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			TestUtils.captureScreenshot(driver);
		}
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
