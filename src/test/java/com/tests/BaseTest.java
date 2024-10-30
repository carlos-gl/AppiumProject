package com.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
  protected AppiumDriver<MobileElement> driver;

  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
    caps.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));

    caps.setCapability("device", "Google Pixel 8");
    caps.setCapability("os_version", "14.0");
    caps.setCapability("app", "bs://0ea68627d6d4ec8c86bafbd1f28427d6a9106a1f");
    caps.setCapability("project", "Projeto Appium");
    caps.setCapability("build", "Appium-GitHubActions-Build");
    caps.setCapability("name", "GitHub Actions Appium Test");

    driver = new AndroidDriver<>(new URL("https://hub-cloud.browserstack.com/wd/hub"), caps);

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
