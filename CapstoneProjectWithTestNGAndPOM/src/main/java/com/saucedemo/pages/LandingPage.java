package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	@FindBy (id = "user-name")
	private WebElement userNameTextBox;
	
	@FindBy (id = "password")
	private WebElement passwordTextBox;

	@FindBy (id = "login-button")
	private WebElement loginBtn;
	
	@FindBy (xpath = "//h3[contains(@data-test, 'error')]")
	private WebElement errorMsg;
	
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUsername (String username) {
		userNameTextBox.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	public void clickLoginBtn(){
		loginBtn.click();
	}
	public String getErrorMessage() {
		String text = errorMsg.getText() ;
		return text;
	}
}
