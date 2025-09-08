package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By shoppingCartLink = By.linkText("Shopping cart");
    By termsOfService = By.xpath("//input[id='termsofservice']");
    By checkoutButton = By.id("checkout");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void proceedToCheckout() {
        // Go to shopping cart
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();

        // Accept terms of service
        wait.until(ExpectedConditions.elementToBeClickable(termsOfService)).click();

        // Click checkout
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
