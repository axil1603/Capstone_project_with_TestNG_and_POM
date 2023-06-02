package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {
	
	@FindBy (xpath = "//div[contains(@class, 'complete-text')]")
	private WebElement successMessage;
	
	@FindBy (xpath = "//h2[contains(@class, 'complete-header')]")
	private WebElement ThankYouMessage;
	
	
	public CheckoutComplete (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getSuccessMsg() {
		String text = successMessage.getText();
		return text;
	}
	public String getThankYouMessage() {
		String text = ThankYouMessage.getText();
		return text;
	}
}
