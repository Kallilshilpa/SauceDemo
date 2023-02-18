package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsHomePage;

public class AddRemoveTest extends BaseTest {
	
	ProductsHomePage homepage;
	LoginPage login;
	
	@Test(priority = 1, description = "Validate add to cart and remove from cart button functionalities")
	public void addAndRemoveTest() {
		login=new LoginPage(driver);
		System.out.println("Logging into user account...");
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginBtn();
		
		homepage=new ProductsHomePage(driver);
		System.out.println("Adding an item to the cart");
		homepage.clickAddtoCart();
		String expected="1";
		String actual=homepage.getCartStatus();
		System.out.println("Number of items in the cart:"+actual);
		System.out.println("Validating add to cart button functionality...");
		Assert.assertEquals(actual, expected,"cart is not getting upddated, add functionality is not working");
		
		System.out.println("Validating remove button functionality...");
		homepage.clickRemoveCart();
		System.out.println(homepage.checkCartEmpty());
		boolean act=homepage.checkCartEmpty();
		System.out.println("Validating remove button functionality...");
		Assert.assertEquals(true, act,"Cart is not empty");

	}

}
