package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckoutComplete;
import com.saucedemo.pages.CheckoutInfo;
import com.saucedemo.pages.CheckoutSummary;
import com.saucedemo.pages.Inventory;
import com.saucedemo.pages.LandingPage;
import com.saucedemo.pages.ShoppingCart;

public class BuyMostExpensiveAndThirdProductsTest extends BaseTest {
	
	@Test
	public void BuyMostExpensiveAndThirdProducts() {
		
		//3) Enter the username as 'standard_user' in Username textbox
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername("standard_user");
				
		//4) Enter the password as 'secret_sauce' in Password textbox
		landingPage.enterPassword("secret_sauce");
						
		//5) Click on 'Login' button
		landingPage.clickLoginBtn();
		
		//6) Add the first and third products to the cart
		Inventory inventory = new Inventory(driver);
		inventory.addFirstProduct();
		inventory.addThirdProduct();
		
		//7) remove first products from the cart
		inventory.removeFirstProduct();
		
		//8) Click on cart icon at top right corner.
		inventory.clickOnShoppingCart();
		
		//9) Verify the text ‘Your Cart’ is displayed at the top left corner of the page.
		ShoppingCart shoppingCart = new ShoppingCart(driver);
		String expectedText = "Your Cart";
		String actualText = shoppingCart.VerifyDisplayedText();
		Assert.assertEquals(actualText, expectedText);
		
		//10) Click on ‘Continue Shopping’ button.
		shoppingCart.clickContinueShoppingBtn();
		
		//11) Sort the items based on Price from high to low.
		inventory.sortProductPriceHighToLow();
		
		//12) Add the most expensive item to the cart.
		inventory.addMostExpensiveProduct();
		
		//13) Click on cart icon at top right corner.
		inventory.clickOnShoppingCart();
		
		//14)verify that there are 2 items in the cart.
		int expectedTotalItemsInCart = 2;
		int totalItemsInCart = shoppingCart.verifyTotalItemsInCart();
		Assert.assertEquals(totalItemsInCart, expectedTotalItemsInCart);
		
		//15) Click on ‘Checkout’ button.
		shoppingCart.clickOnCheckoutButton();
		
		//16) fill out checkout information.
		CheckoutInfo checkoutInfo = new CheckoutInfo(driver);
		checkoutInfo.enterFirstName("Jason");
		checkoutInfo.enterLastName("Bourne");
		checkoutInfo.enterPostalCode("10001");
		
		//17) Click on ‘Continue’ button.
		checkoutInfo.clickCintinueBtn();
		
		//18) Click on ‘Finish’ button on the next page.
		CheckoutSummary checkoutSummary = new CheckoutSummary(driver);
		checkoutSummary.clickOnFinishBtn();
		
		//19) Verify the success message – ‘Thank you for your order!’ is displayed to the user.
		CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
		String expectedMessage = "Thank you for your order!";
		String actualMessage = checkoutComplete.getThankYouMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
		
		
	}

}
