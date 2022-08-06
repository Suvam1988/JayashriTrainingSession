package com.advancedselenium.org.jayashrirasane.glue;

import org.junit.Assert;
import com.advancedselenium.org.jayashrirasane.framework.TestDataLoader;
import com.advancedselenium.org.jayashrirasane.pages.HomePage;
import com.advancedselenium.org.jayashrirasane.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	HomePage homePage;
	LoginPage loginPage;

	@Given("application is up and running and its launched successfully")
	public void launchApplication() {
		homePage = new HomePage();
		loginPage = homePage.clickOnLogin();
	}

	@When("enter username")
	public void enterUsername() {
		loginPage.enterUser(TestDataLoader.propertiesFileReader("email"));
	}

	@When("enter password")
	public void enterPassword() {
		loginPage.enterPassword(TestDataLoader.propertiesFileReader("password"));
	}

	@When("click on login")
	public void login() {
		loginPage.clickOnLogin();
	}

	@Then("user logged in successfully")
	public void checkLoginSuccessful() {
		Assert.assertTrue(loginPage.isErrorTextPresent());
	}

}
