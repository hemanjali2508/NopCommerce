package tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductPage;

public class AddToCartTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void testAddToCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        // Add assertions
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}