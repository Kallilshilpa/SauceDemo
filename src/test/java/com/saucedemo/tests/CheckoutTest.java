package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartCheckcoutComplete;
import com.saucedemo.pages.CartCheckoutInfoPage;
import com.saucedemo.pages.CartCheckoutOverviewPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsHomePage;
import com.saucedemo.utils.TestUtils;

public class CheckoutTest extends BaseTest {
	
	ProductsHomePage homepage;
	LoginPage login;
	CartPage cart;
	CartCheckoutInfoPage info;
	CartCheckoutOverviewPage overview;
	CartCheckcoutComplete complete;
	
	@Test(priority = 1, description = "Validate checkout functionality")
	public void checkOutTest() {
		System.out.println("Logging into the user account");
		login=new LoginPage(driver);
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickOnLoginBtn();
		
		homepage=new ProductsHomePage(driver);
		System.out.println("Adding item to cart");
		homepage.clickAddtoCart();
		String expected="1";
		String actual=homepage.getCartStatus();
		System.out.println("Number of items in the cart:"+actual);
		System.out.println("Validating add to cart button functionality...");
		Assert.assertEquals(actual, expected,"cart is not getting upddated");
		
		System.out.println("Clicking on cart icon");
		homepage.clickCartBtn();
		
		System.out.println("Clicking on checkout button inside cart");
		cart=new CartPage(driver);
		cart.clickCheckoutBtn();
		
		info=new CartCheckoutInfoPage(driver);
		System.out.println("Entering user info...");
		info.enterFirstname(TestUtils.generateRandomString(5, true, false));
		info.enterLastname(TestUtils.generateRandomString(5, true, false));
		info.enterZipcode(TestUtils.generateRandomString(5, false, true));
		info.clickContinueBtn();
		
		overview=new CartCheckoutOverviewPage(driver);
		System.out.println("Clicking on finish button");
		overview.clickOnFinishBtn();
		
		complete=new CartCheckcoutComplete(driver);
		System.out.println("Verifying checkout complete");
		boolean act=complete.checkOrderConfirmation();
		Assert.assertTrue(act, "order is not completed");
		
	}

}
