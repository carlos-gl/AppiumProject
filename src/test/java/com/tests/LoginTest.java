package com.tests;

import com.pages.InventoryPage;
import com.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Before
    public void initializePages() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.openMenu();
        loginPage.enterCredentials("bod@example.com", "10203040");
        loginPage.submitLogin();

        assertTrue(inventoryPage.isItemDisplayed());
    }
}
