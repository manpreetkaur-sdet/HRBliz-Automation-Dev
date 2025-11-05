package utils;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

public class Wait extends BaseClass {

    private int waitTime = 45;
    private int longwaitTime = 150;
    private int extralongTime = 300;
    private WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    private WebDriverWait extralongWebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(extralongTime));

    @And("^I wait (\\d+) seconds for .*$")
    public void iWaitSecondsForPageToLoad(int seconds) throws Throwable {
        Thread.sleep(seconds * 1000);
    }

    public void waitAndClick(By by) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void waitUntilPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));

        wait.until(e -> {
            return (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")) ? true : false;
        });
    }

    public void waitUntilVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitAndClick(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return element;
    }

    public void waitLongUntilLoaderNotPresent(WebElement ele) throws InterruptedException {
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(extralongTime));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
}
