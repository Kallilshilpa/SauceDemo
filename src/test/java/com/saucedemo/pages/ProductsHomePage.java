package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsHomePage {
	WebDriver driver;

	@FindBy(xpath="//button[text()='Add to cart'][1]")
	private WebElement addCartBtn;
	
	@FindBy(xpath="//button[text()='Remove'][1]")
	private WebElement removeCartBtn;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement cartContent;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cartBtn;
	
	public ProductsHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddtoCart() {
		addCartBtn.click();
	}
	
	public String getCartStatus() {
		return cartContent.getText();
	}
	
	public boolean checkCartEmpty() {
		if((driver.findElements(By.xpath("//span[@class='shopping_cart_badge']"))).isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void clickRemoveCart() {
		removeCartBtn.click();
	}
	
	public void clickCartBtn() {
		cartBtn.click();
	}
	
	
}
