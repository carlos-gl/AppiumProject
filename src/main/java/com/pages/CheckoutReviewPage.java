package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CheckoutReviewPage {
  private final AppiumDriver<MobileElement> driver;

  private final By placeOrderButton = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
  private final By fullNameTV = By.id("com.saucelabs.mydemoapp.android:id/fullNameTV");
  private final By addressTV = By.id("com.saucelabs.mydemoapp.android:id/addressTV");
  private final By cityTV = By.id("com.saucelabs.mydemoapp.android:id/cityTV");
  private final By countryTV = By.id("com.saucelabs.mydemoapp.android:id/countryTV");
  private final By cardHolderTV = By.id("com.saucelabs.mydemoapp.android:id/cardHolderTV");
  private final By completeOrderField = By.id("com.saucelabs.mydemoapp.android:id/completeTV");
  public CheckoutReviewPage(AppiumDriver<MobileElement> driver) {
    this.driver = driver;
  }

  public boolean isCompleteFieldDisplayed() {
    return driver.findElement(completeOrderField).isDisplayed();
  }
  public void clickPlaceOrder(){
    driver.findElement(placeOrderButton).click();
  }

  public String getFullName() {
    return driver.findElement(fullNameTV).getText();
  }

  public String getAddress() {
    return driver.findElement(addressTV).getText();
  }

  public String getCity() {
    return driver.findElement(cityTV).getText();
  }

  public String getCountry() {
    return driver.findElement(countryTV).getText();
  }

  public String getCardHolder() {
    return driver.findElement(cardHolderTV).getText();
  }

}
