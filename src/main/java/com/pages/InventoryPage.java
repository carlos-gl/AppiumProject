
package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class InventoryPage {
    private final AppiumDriver<MobileElement> driver;

    private final By itemTitle = By.id("com.saucelabs.mydemoapp.android:id/productTV");
    private final By itemInventory = By.xpath("(//android.widget.ImageView[@content-desc='Product Image'])[1]");
    private final By cartIcon = By.id("com.saucelabs.mydemoapp.android:id/cartIV");
    private final By buttonAdd = By.id("com.saucelabs.mydemoapp.android:id/cartBt");

    public InventoryPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public boolean isItemDisplayed() {
        return driver.findElement(itemTitle).isDisplayed();
    }
    public void addItem() {
        driver.findElement(itemInventory).click();
        driver.findElement(buttonAdd).click();
    }
    public void clickCart() {
        driver.findElement(cartIcon).click();
        driver.findElement(buttonAdd).click();
    }
}
