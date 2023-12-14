package com.demoblaze.pages;

import com.demoblaze.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public void loginAsStandardUser(String someUsername, String somePassword) throws InterruptedException {
        enterText(someUsername, By.cssSelector("#user-name"));
        enterText(somePassword, By.cssSelector("#password"));
        findByAndClick("loginButton", By.cssSelector("#login-button"));
        String products = getElementText(By.cssSelector(".header_secondary_container>span"));
        Assert.assertEquals(products, "Products");
    }

}
