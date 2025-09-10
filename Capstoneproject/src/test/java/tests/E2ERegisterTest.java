package tests;



import core.BaseTest;
import pages.*;

import java.util.UUID;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ERegisterTest extends BaseTest {

	@Test
	public void testEndToEndEcommerceFlow() throws InterruptedException {
		// Step 1: Go to Login Page
		HomePage homePage = new HomePage(driver);
		homePage.clickRegister();

		// Step 2:Registration
		RegisterPage register = new RegisterPage(driver);
		register.selectGenderMale();
		register.enterFirstName("Hemanjali");
		register.enterLastName("Muli");

		// Generate unique email to avoid duplicate
		// String email = "hemanjalimuli@gmail.com";
		String email = "Hemanjali" + UUID.randomUUID().toString().substring(0, 5) + "@gmail.com"; // New user
		register.enterEmail(email);

		register.enterPassword("123123123");
		register.enterConfirmPassword("123123123");
		register.clickRegister();

		Thread.sleep(2000);

		// Verify Register
		By successMsg = By.className("result");
		String message = driver.findElement(successMsg).getText();
		Assert.assertTrue(message.contains("Your registration completed"), "Registration Failed: " + message);

		System.out.println("Registration successful for: " + email);

		// Step 3: Search for a product
		ProductSearchPage searchPage = new ProductSearchPage(driver);
		searchPage.searchProduct("laptop"); // search keyword
		searchPage.selectFirstProduct();
		searchPage.addToCart();
		searchPage.clickClose();
		System.out.println("Product added to cart");

		// Step 4: Proceed to cart
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOpenCart();
		cartPage.clikAcceptTerm();
		cartPage.proceedToCheckout();
		System.out.println("Navigated to cart and proceeding to checkout");

		// step 5: Address details

		AddressPage address = new AddressPage(driver);
		address.selectNewCountry();
		address.selectNewState();
		address.enterNewCity("Pulivendula");
		address.enterNewFirstAddress("Bhetal church Road");
		address.enterNewPostalCode("516390");
		address.enterNewPhoneNumber("9492993566");

		// complete checkout process

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.proceedThroughCheckout();

		// Step 6: Assert order confirmation page
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("Your order"), "Order not confirmed!");
		System.out.println("Order placed successfully!");
	}
}