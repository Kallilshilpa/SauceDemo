package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartCheckoutOverviewPage {
	
	WebDriver driver;
	
	@FindBy(id="finish")
	private WebElement finishBtn;
	
	public CartCheckoutOverviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFinishBtn() {
		finishBtn.click();
	}
}
