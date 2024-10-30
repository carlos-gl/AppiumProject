package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class CheckoutPaymentPage {
  private final AppiumDriver<MobileElement> driver;

  private final By fullNameField = By.id("com.saucelabs.mydemoapp.android:id/nameET");
  private final By cardNumberField = By.id("com.saucelabs.mydemoapp.android:id/cardNumberET");
  private final By expirationDateField = By.id("com.saucelabs.mydemoapp.android:id/expirationDateET");
  private final By securityCodeField = By.id("com.saucelabs.mydemoapp.android:id/securityCodeET");
  private final By reviewOrderButton = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
  public CheckoutPaymentPage(AppiumDriver<MobileElement> driver) {
    this.driver = driver;
  }

  public void fillPaymentForm(String fullName, String cardNumber, String expirationDate, String securityCode) {
    driver.findElement(fullNameField).sendKeys(fullName);
    driver.findElement(cardNumberField).sendKeys(cardNumber);
    driver.findElement(expirationDateField).sendKeys(expirationDate);
    driver.findElement(securityCodeField).sendKeys(securityCode);
    driver.findElement(reviewOrderButton).click();
  }
}
