package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartCheckoutInfoPage {
	
	WebDriver driver;
	
	@FindBy(id="first-name")
	private WebElement firstNameTF;
	
	@FindBy(id="last-name")
	private WebElement lastNameTF;
	
	@FindBy(id="postal-code")
	private WebElement postalCodeTF;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	
	public CartCheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstname(String firstname) {
		firstNameTF.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		lastNameTF.sendKeys(lastname);
	}
	
	public void enterZipcode(String zip) {
		postalCodeTF.sendKeys(zip);
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
}
