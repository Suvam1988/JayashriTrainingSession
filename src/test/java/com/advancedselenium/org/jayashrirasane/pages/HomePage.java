package com.advancedselenium.org.jayashrirasane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advancedselenium.org.jayashrirasane.framework.CommonUtilities;

public class HomePage extends CommonUtilities {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath = "//span[text()='Log In']/..")
    private WebElement loginLink;

    public LoginPage clickOnLogin() {
    	click(loginLink);
        return PageFactory.initElements(driver, LoginPage.class);
    }

}
