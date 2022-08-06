package com.advancedselenium.org.jayashrirasane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.advancedselenium.org.jayashrirasane.framework.CommonUtilities;

public class LoginPage extends CommonUtilities {

	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//div[text()='Login']")
	private WebElement login;
	@FindBy(xpath = "//p[text()='Invalid login']")
	private WebElement invalidLoginMessage;

	public void enterUser(String emailid) {
		sendKeys(email, emailid);
	}

	public void enterPassword(String pass) {
		sendKeys(password, pass);
	}

	public void clickOnLogin() {
	javaScriptClick(login);
	}

	public boolean isErrorTextPresent() {

		return invalidLoginMessage.isDisplayed();
	}

}
