package tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;

public class SignInTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        homePage.clickLoginLink();
        loginPage.login("deva123@example.com", "Test@123");

        // Example assertion: check if login was successful by verifying page title or user icon
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("nopCommerce demo store"), "Login failed or unexpected page title");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}