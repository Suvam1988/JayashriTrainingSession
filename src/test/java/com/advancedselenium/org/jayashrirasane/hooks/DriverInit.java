package com.advancedselenium.org.jayashrirasane.hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.advancedselenium.org.jayashrirasane.framework.TestDataLoader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInit {
	public static WebDriver driver;
	private static String browser = null;
	private static String url = null;
    
	@Before
	public static void initDriver() {
		browser = TestDataLoader.propertiesFileReader("browser");
		url = TestDataLoader.propertiesFileReader("url");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (driver == null) {
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			if (driver == null) {
				driver = new FirefoxDriver();
			}
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			if (driver == null) {
				driver = new EdgeDriver();
			}
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public static void tearDown() {
		driver.close();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image"); 
		
	}

}
