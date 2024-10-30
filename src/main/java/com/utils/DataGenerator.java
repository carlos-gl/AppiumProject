package com.utils;

import net.datafaker.Faker;
import java.util.HashMap;
import java.util.Map;

public class DataGenerator {
  private static final Faker faker = new Faker();

  public static Map<String, String> generateCheckoutData() {
    Map<String, String> checkoutData = new HashMap<>();
    checkoutData.put("fullName", faker.name().fullName());
    checkoutData.put("address", faker.address().streetAddress());
    checkoutData.put("address2", faker.address().secondaryAddress());
    checkoutData.put("city", faker.address().city());
    checkoutData.put("state", faker.address().state());
    checkoutData.put("zipCode", faker.address().zipCode());
    checkoutData.put("country", faker.address().country());

    return checkoutData;
  }

  public static Map<String, String> generatePaymentData() {
    Map<String, String> paymentData = new HashMap<>();
    paymentData.put("fullName", faker.name().fullName());
    paymentData.put("cardNumber", faker.finance().creditCard());
    paymentData.put("expiryDate", "01/30");
    paymentData.put("cvv", faker.number().digits(3));

    return paymentData;
  }
}
