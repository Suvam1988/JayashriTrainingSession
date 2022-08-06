package com.advancedselenium.org.jayashrirasane.framework;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advancedselenium.org.jayashrirasane.hooks.DriverInit;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class CommonUtilities extends DriverInit {
    private static final Logger logger = LogManager.getLogger(CommonUtilities.class);


    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForElementToBeClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));

    }

    public void waitForElementToBeVissible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));

    }

    public boolean click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
        try {
            takeScreenShots();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("click on the element successful");
        return true;
    }

    public boolean click(By element) {
        waitForElementToBeClickable(element);
        driver.findElement(element).click();
        try {
            takeScreenShots();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("click on the element successful");
        return true;
    }

    public boolean sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.sendKeys(text);
        try {
            takeScreenShots();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Sendkeys successful");
        return true;
    }

    public boolean sendKeys(By element, String text) {
        waitForElementToBeVissible(element);
        driver.findElement(element).sendKeys(text);
        try {
            takeScreenShots();
        } catch (IOException e) {

            e.printStackTrace();
        }
        logger.info("Sendkeys successful");
        return true;
    }

    public boolean moseHover(WebElement element) {
        waitForElementToBeVisible(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        try {
            takeScreenShots();
        } catch (IOException e) {

            e.printStackTrace();
        }
        logger.info("mouse hover successful");
        return true;
    }

    public boolean doubleClick(WebElement element) {
        waitForElementToBeClickable(element);
        Actions action = new Actions(driver);
        action.doubleClick(element).build().perform();
        try {
            takeScreenShots();
        } catch (IOException e) {

            e.printStackTrace();
        }
        logger.info("double successful");
        return true;
    }

    public boolean rightClick(WebElement element) {
        waitForElementToBeClickable(element);
        Actions action = new Actions(driver);
        action.contextClick(element).build().perform();
        try {
            takeScreenShots();
        } catch (IOException e) {

            e.printStackTrace();
        }
        logger.info("right click successful");
        return true;
    }

    public void takeScreenShots() throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "screenShots" + File.separator + "screenShot_" + LocalDateTime.now().toString().replaceAll("-", "_").replaceAll("\\.", "_").replaceAll(":", "_") + ".png"));
    }

    public boolean javaScriptClick(WebElement element) {
        String javascript = "arguments[0].click()";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript, element);
        return true;
    }

}
