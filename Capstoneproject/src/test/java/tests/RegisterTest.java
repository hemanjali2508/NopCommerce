package tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void testRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("Deva", "Test", "deva123@example.com", "Test@123");
        // Add assertions
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}