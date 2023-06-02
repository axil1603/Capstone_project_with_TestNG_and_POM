package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Inventory {
		
	@FindBy (id = "add-to-cart-sauce-labs-backpack")
	private WebElement firstProduct;
	
	@FindBy (id="add-to-cart-sauce-labs-bike-light")
	private WebElement secoundProduct;
	
	@FindBy (id ="shopping_cart_container")
	private WebElement shoppingCartBtn;
	
	@FindBy (xpath = "//select[contains(@class,'product_sort_container')]")
	private WebElement sortingDropDown;
	
	@FindBy (id = "add-to-cart-sauce-labs-onesie")
	private WebElement cheapestProduct;
	
	@FindBy (id="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement thirdProduct;
	
	@FindBy (id = "remove-sauce-labs-backpack")
	private WebElement removeBtn;
	
	@FindBy (id = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement mostExpensiveProduct;
	
	
	public Inventory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void addFirstProduct() {
		firstProduct.click();
	}
	public void addSecoundProduct() {
		secoundProduct.click();
	}
	public void clickOnShoppingCart() {
		shoppingCartBtn.click();
	}
	public void sortProductPriceLowToHigh() {
		Select sortPriceLowToHigh = new Select(sortingDropDown);
		sortPriceLowToHigh.selectByVisibleText("Price (low to high)");
	}
	public void addCheapestProduct() {
		cheapestProduct.click();
	}
	public void addThirdProduct() {
		thirdProduct.click();
	}
	public void removeFirstProduct() {
		removeBtn.click();
	}
	public void sortProductPriceHighToLow() {
		Select sortPriceHighToLow = new Select(sortingDropDown);
		sortPriceHighToLow.selectByVisibleText("Price (high to low)");
	}
	public void addMostExpensiveProduct() {
		mostExpensiveProduct.click();
	}
}
