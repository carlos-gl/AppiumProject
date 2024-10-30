package com.tests;

import com.pages.*;
import com.utils.DataGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest{
  Map<String, String> checkoutData = DataGenerator.generateCheckoutData();
  Map<String, String> paymentData = DataGenerator.generatePaymentData();
  private InventoryPage inventoryPage;
  private LoginPage loginPage;
  private CheckoutPage checkoutPage;
  private CheckoutPaymentPage checkoutPaymentPage;
  private CheckoutReviewPage checkoutReviewPage;

  @Before
  public void initializePages() {
    inventoryPage = new InventoryPage(driver);
    loginPage = new LoginPage(driver);
    checkoutPage = new CheckoutPage(driver);
    checkoutPaymentPage = new CheckoutPaymentPage(driver);
    checkoutReviewPage = new CheckoutReviewPage(driver);
  }

  @Test
  public void checkoutProduct() {

    inventoryPage.addItem();
    inventoryPage.clickCart();
    loginPage.login("bod@example.com", "10203040");

    // valida se está na tela de checkout
    assertTrue(checkoutPage.isTitleCheckoutDisplayed());

    checkoutPage.fillCheckoutForm(
            checkoutData.get("fullName"),
            checkoutData.get("address"),
            checkoutData.get("address2"),
            checkoutData.get("city"),
            checkoutData.get("state"),
            checkoutData.get("zipCode"),
            checkoutData.get("country")
    );

    checkoutPaymentPage.fillPaymentForm(
            paymentData.get("fullName"),
            paymentData.get("cardNumber"),
            paymentData.get("expiryDate"),
            paymentData.get("cvv")
    );
      // valida se os dados preenchidos estão iguais na tela de review
    validateReviewOrderScreen();

    checkoutReviewPage.clickPlaceOrder();

    // valida se finalizou o pedido corretamente
    checkoutReviewPage.isCompleteFieldDisplayed();
  }

  private void validateReviewOrderScreen() {
    // Recupera os dados da tela de review order
    String displayedFullName = checkoutReviewPage.getFullName();
    String displayedAddress = checkoutReviewPage.getAddress();
    String displayedCity = checkoutReviewPage.getCity();
    String displayedCountry = checkoutReviewPage.getCountry();
    String displayedCardHolder = checkoutReviewPage.getCardHolder();

    // Validações dos dados da tela de review order
    assertEquals(checkoutData.get("fullName"), displayedFullName);
    assertEquals(checkoutData.get("address"), displayedAddress);
    assertEquals(checkoutData.get("city") + ", " + checkoutData.get("state"), displayedCity);
    assertEquals(checkoutData.get("country") + ", " + checkoutData.get("zipCode"), displayedCountry);
    assertEquals(paymentData.get("fullName"), displayedCardHolder);
  }

}
