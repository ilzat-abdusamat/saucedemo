package com.saucedemo.tests;

import com.saucedemo.base.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BasePage {

    LoginPage loginPage;

    public ProductsTest() {
        this.loginPage = new LoginPage();
    }


    @Test
    public void addToCartTest() throws InterruptedException {

        loginPage.loginAsStandardUser("standard_user", "secret_sauce");

        findByAndClick("Add to cart", By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        WebElement cartBadge = waitUntilVisible(By.cssSelector(".shopping_cart_badge"));

        String productItemCount = cartBadge.getText();
        Assert.assertEquals(productItemCount, "1");

    }


}
