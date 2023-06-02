package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckoutComplete;
import com.saucedemo.pages.CheckoutInfo;
import com.saucedemo.pages.CheckoutSummary;
import com.saucedemo.pages.Inventory;
import com.saucedemo.pages.LandingPage;
import com.saucedemo.pages.ShoppingCart;

public class BuyCheapestProductTest extends BaseTest {
	
	@Test
	public void BuyCheapestProduct() {
		
		//3) Enter the username as 'standard_user' in Username textbox
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername("standard_user");
		
		//4) Enter the password as 'secret_sauce' in Password textbox
		landingPage.enterPassword("secret_sauce");
				
		//5) Click on 'Login' button
		landingPage.clickLoginBtn();
				
		//6) Sort the items based on Price from low to high.
		Inventory inventory = new Inventory(driver);
		inventory.sortProductPriceLowToHigh();
		
		//7) Add the first item with low price to cart.
		inventory.addCheapestProduct();
		
		//8) Verify the same item which you selected on the previous page has been added to cart.
		inventory.clickOnShoppingCart();
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		String expectedProductName = "Sauce Labs Onesie";
		String actualProductName = shoppingCart.verifySelectedProduct();
		Assert.assertEquals(actualProductName, expectedProductName);
		
		//9) Click on ‘Checkout’ button.
		shoppingCart.clickOnCheckoutButton();
		
		//10) Enter your first name in 'First Name' textbox
		CheckoutInfo checkoutInfo = new CheckoutInfo(driver);
		checkoutInfo.enterFirstName("Jason");
				
		//11) Enter your last name on 'Last Name' textbox
		checkoutInfo.enterLastName("Bourne");
				
		//12) Enter Postal Code in ‘Postal Code’ textbox.
		checkoutInfo.enterPostalCode("10001");
		
		//13) Click on ‘Continue’ button.
		checkoutInfo.clickCintinueBtn();
				
		//14) Click on ‘Finish’ button on the next page.
		CheckoutSummary checkoutSummary = new CheckoutSummary(driver);
		checkoutSummary.clickOnFinishBtn();
		
		//15) Verify the success message – ‘Thank you for your order!’ is displayed to the user.
		CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
		String expectedMessage = "Thank you for your order!";
		String actualMessage = checkoutComplete.getThankYouMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}

}
