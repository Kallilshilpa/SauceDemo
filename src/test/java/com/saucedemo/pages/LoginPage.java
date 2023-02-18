package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="user-name")
	private WebElement usernameTb;
	
	@FindBy(id="password")
	private WebElement passwordTb;
	
	@FindBy(id="login-button")
	private WebElement LoginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String un) {
		usernameTb.sendKeys(un);
	}
	
	public void enterPassword(String pw) {
		passwordTb.sendKeys(pw);
	}
	
	public void clickOnLoginBtn() {
		LoginBtn.click();
	}

}
