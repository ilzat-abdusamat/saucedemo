package com.saucedemo.base;

import com.saucedemo.utils.Browser;
import com.saucedemo.utils.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class BasePage {

    public static WebDriver driver; // it is gonna remain its value

    @BeforeMethod
    public void setup() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getBrowser(Browser.CHROME);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void findByAndClick(String elementName, By locator) throws InterruptedException {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public String getElementText(By locator) {
        WebElement element = driver.findElement(locator); //  elementNotFoundException
        return element.getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void inputTextAndPressEnter(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void findElementAndSelectByIndex(By locator, int index) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void enterText(String text, By locator) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public WebElement waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public Alert waitUntilAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

}