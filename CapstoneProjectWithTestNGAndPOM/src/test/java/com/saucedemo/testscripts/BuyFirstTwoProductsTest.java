package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckoutComplete;
import com.saucedemo.pages.CheckoutInfo;
import com.saucedemo.pages.CheckoutSummary;
import com.saucedemo.pages.Inventory;
import com.saucedemo.pages.LandingPage;
import com.saucedemo.pages.ShoppingCart;

public class BuyFirstTwoProductsTest extends BaseTest {
	
	
	@Test
	public void BuyFirstTwoProducts() {	
		
		//3) Enter the username as 'standard_user' in Username textbox
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername("standard_user");
		
		//4) Enter the password as 'secret_sauce' in Password textbox
		landingPage.enterPassword("secret_sauce");
		
		//5) Click on 'Login' button
		landingPage.clickLoginBtn();
		
		//6) Add the first 2 products to the cart
		Inventory inventory = new Inventory(driver);
		inventory.addFirstProduct();
		inventory.addSecoundProduct();
		
		//7) Click on the Cart Icon
		inventory.clickOnShoppingCart();
		
		//8) Click on 'Checkout' button
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		shoppingCart.clickOnCheckoutButton();
		
		//9) Enter your first name in 'First Name' textbox
		CheckoutInfo checkoutInfo = new CheckoutInfo(driver);
		checkoutInfo.enterFirstName("Jason");
		
		//10) Enter your last name on 'Last Name' textbox
		checkoutInfo.enterLastName("Bourne");
		
		//11) Enter Postal Code in ‘Postal Code’ textbox.
		checkoutInfo.enterPostalCode("10001");
		
		//12) Click on ‘Continue’ button.
		checkoutInfo.clickCintinueBtn();
		
		//13) Click on ‘Finish’ button on the next page.
		CheckoutSummary checkoutSummary = new CheckoutSummary(driver);
		checkoutSummary.clickOnFinishBtn();
		
		//14) Verify the success message – ‘Your order has been dispatched, and will arrive just as fast as the pony can get there!’ is displayed.
		CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
		String expectedMessage = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actualMessage = checkoutComplete.getSuccessMsg();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}
