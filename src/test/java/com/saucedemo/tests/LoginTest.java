package com.saucedemo.tests;

import com.saucedemo.base.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {

    LoginPage loginPage;

    public LoginTest() {
        this.loginPage = new LoginPage();
    }

    @Test(description = "adding items to the shopping cart ")
    public void verifyAlertIsDisplayed_OnInitialLogin() throws InterruptedException {
        loginPage.loginAsStandardUser("standard_user", "secret_sauce");
        Alert alert = waitUntilAlertPresent();
        System.out.println("-----" + alert.getText());
    }

    @Test(description = "adding items to the shopping cart ")
    public void loginTest() throws InterruptedException {
        loginPage.loginAsStandardUser("standard_user", "secret_sauce");
        By homePageHeaderLocator = By.cssSelector(".app_logo");
        WebElement visibleHeader = waitUntilVisible(homePageHeaderLocator);
        String text = visibleHeader.getText();
        Assert.assertEquals(text, "Swag Labs");
    }

    @Test(description = "adding items to the shopping cart ")
    public void addItems() throws InterruptedException {
        loginPage.loginAsStandardUser("standard_user", "secret_sauce");
        findByAndClick("backpackAddToCartButton", By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        findByAndClick("babyClothAddToCartButton", By.cssSelector("#add-to-cart-sauce-labs-onesie"));
        findByAndClick("jacketAddToCartButton", By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket"));
        By cartBadge_Locator = By.cssSelector(".shopping_cart_badge");
        WebElement cartBadge_Element = waitUntilVisible(cartBadge_Locator);
        String text = cartBadge_Element.getText();
        Assert.assertEquals(text, "3");
    }
}
