
package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage {
    private final AppiumDriver<MobileElement> driver;

    private final By usernameField = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By passwordField = By.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private final By menuButton = By.id("com.saucelabs.mydemoapp.android:id/menuIV");
    private final By LoginMenuButton = By.xpath("//android.widget.TextView[@text='Log In']");
    private final By LoginButton = By.id("com.saucelabs.mydemoapp.android:id/loginBtn");

    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void openMenu() {
        driver.findElement(menuButton).click();
        driver.findElement(LoginMenuButton).click();
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(LoginButton).click();
    }
    public void login(String username, String password) {
        enterCredentials(username, password);
        submitLogin();
    }
}

