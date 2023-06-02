package com.saucedemo.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pages.LandingPage;

public class VerifyLockedOutUserErrorMessageTest extends BaseTest {
	
	@Test
	public void VerifyLockedOutUserMessage() {
		
		//3) Enter the username as 'locked_out_user' in Username textbox
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterUsername("locked_out_user");
		
		//4) Enter the password as 'secret_sauce' in Password textbox
		landingPage.enterPassword("secret_sauce");
		
		//5) Click on 'Login' button
		landingPage.clickLoginBtn();
		
		//6) Verify the error message – ‘Epic sadface: Sorry, this user has been locked out.’ is displayed.
		String expectedErrMsg = "Epic sadface: Sorry, this user has been locked out."; 
		String actualErrMsg = landingPage.getErrorMessage();
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
	

}
