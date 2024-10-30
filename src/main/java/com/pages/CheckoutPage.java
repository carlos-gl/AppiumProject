package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CheckoutPage {
  private final AppiumDriver<MobileElement> driver;
  private final By checkoutTitle = By.id("com.saucelabs.mydemoapp.android:id/checkoutTitleTV");
  private final By fullNameField = By.id("com.saucelabs.mydemoapp.android:id/fullNameET");
  private final By addressField = By.id("com.saucelabs.mydemoapp.android:id/address1ET");
  private final By address2Field = By.id("com.saucelabs.mydemoapp.android:id/address2ET");
  private final By cityField = By.id("com.saucelabs.mydemoapp.android:id/cityET");
  private final By stateField = By.id("com.saucelabs.mydemoapp.android:id/stateET");
  private final By zipCodeField = By.id("com.saucelabs.mydemoapp.android:id/zipET");
  private final By countryField = By.id("com.saucelabs.mydemoapp.android:id/countryET");
  private final By paymentButton = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

  public CheckoutPage(AppiumDriver<MobileElement> driver) {
    this.driver = driver;
  }

  public boolean isTitleCheckoutDisplayed() {
    return driver.findElement(checkoutTitle).isDisplayed();
  }
  public void fillCheckoutForm(String fullName, String address, String adress2, String city, String state, String zipCode, String country) {
    driver.findElement(fullNameField).sendKeys(fullName);
    driver.findElement(addressField).sendKeys(address);
    driver.findElement(address2Field).sendKeys(adress2);
    driver.findElement(cityField).sendKeys(city);
    driver.findElement(stateField).sendKeys(state);
    driver.findElement(zipCodeField).sendKeys(zipCode);
    driver.findElement(countryField).sendKeys(country);
    driver.findElement(paymentButton).click();
  }
}
