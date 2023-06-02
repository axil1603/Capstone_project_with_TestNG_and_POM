package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfo {
	
	@FindBy (id = "first-name")
	private WebElement firstNameTextBox;
	
	@FindBy (id = "last-name")
	private WebElement lastNameTextBox;
	
	@FindBy (id = "postal-code")
	private WebElement postalCodeTextBox;
	
	@FindBy (id = "continue")
	private WebElement continueBtn;
	
	@FindBy (xpath = "//h3[contains(@data-test, 'error')]")
	private WebElement errMsg;
	
	
	public CheckoutInfo (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFirstName(String firstname) {
		firstNameTextBox.sendKeys(firstname);
	}
	public void enterLastName(String lastname) {
		lastNameTextBox.sendKeys(lastname);
	}
	public void enterPostalCode(String zipCode) {
		postalCodeTextBox.sendKeys(zipCode);
	}
	public void clickCintinueBtn() {
		continueBtn.click();
	}
	public String getErrMsg() {
		String text = errMsg.getText() ;
		return text;
	}
}
