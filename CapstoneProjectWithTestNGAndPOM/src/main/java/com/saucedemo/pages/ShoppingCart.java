package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	@FindBy (id = "checkout")
	private WebElement checkoutBtn;
	
	@FindBy (xpath = "//div[contains(@class,'inventory_item_name')]")
	private WebElement cheapestProdName;
	
	@FindBy (xpath = "//div[contains(@class,'header_secondary_container')]")
	private WebElement displayedText;
	
	@FindBy (id = "continue-shopping")
	private WebElement continueShoppingBtn;
	
	@FindBy (xpath = "//span[contains(@class,'cart_badge')]")
	private WebElement cartBadge;
	
	
	public ShoppingCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnCheckoutButton() {
		checkoutBtn.click();
	}
	public String verifySelectedProduct(){
		String text = cheapestProdName.getText();
		return text;
	}
	public String VerifyDisplayedText() {
		String text = displayedText.getText();
		return text;
	}
	public void clickContinueShoppingBtn() {
		continueShoppingBtn.click();
	}
	public int verifyTotalItemsInCart() {
		int totalItems = Integer.parseInt(cartBadge.getText());
		return totalItems;
	}
}
