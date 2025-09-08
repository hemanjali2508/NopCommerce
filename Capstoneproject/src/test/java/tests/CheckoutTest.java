package tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void testCheckout() {
        // Add a product to the cart first
        driver.findElement(By.xpath("(//button[contains(text(),'Add to cart')])[1]")).click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();

        // Assert: verify checkout page is opened
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), 
                "Checkout page not opened");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
