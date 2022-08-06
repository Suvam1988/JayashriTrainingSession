package com.advancedselenium.org.jayashrirasane.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, features = {
				"src/test/resources/feature" }, glue = { "com.advancedselenium.org.jayashrirasane.glue",
						"com.advancedselenium.org.jayashrirasane.hooks" })

public class FreeCRMRunner {

}
