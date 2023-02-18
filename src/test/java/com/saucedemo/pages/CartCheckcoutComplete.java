package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartCheckcoutComplete {
	
	WebDriver driver;
	
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	private WebElement orderConfirmTxt;
	
	public CartCheckcoutComplete(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkOrderConfirmation() {
		if(orderConfirmTxt.isDisplayed()) {
			return true;
		}
		return false;
	}

}
