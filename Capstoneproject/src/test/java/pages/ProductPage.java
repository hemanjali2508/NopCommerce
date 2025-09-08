package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    By productLink = By.linkText("Build your own computer");
    By addToCartButton = By.id("add-to-cart-button-1");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(productLink).click();
        driver.findElement(addToCartButton).click();
    }
}