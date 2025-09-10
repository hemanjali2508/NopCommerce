package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import pages.AddressPage;
import pages.HomePage;
import pages.LoginPage;

public class AddressTest extends BaseTest {
	
	@Test
	public void addNewAddress() throws InterruptedException {
		// Go to login page
        HomePage home = new HomePage(driver);
        home.clickLogin();
   
        LoginPage login = new LoginPage(driver);
        login.enterEmail("hemanjalimuli@gmail.com");
        login.enterPassword("123123123");
        login.clickLogin();
     // Verify login
        Assert.assertTrue(login.isLoginSuccessful(), "Login failed!");
        System.out.println("Login successful");
        
	// Open Address Page
    AddressPage addressPage = new AddressPage(driver);

    // Navigate to "My Account -> Addresses -> Add New"
    addressPage.clickOpenAddresses();

    // Fill Address Form
    addressPage.enterFirstName("Hemanjali");
    addressPage.enterLastName("Muli");
    String email = "hemanjalimuli@gmail.com";
    addressPage.enterEmail(email);
    addressPage.selectCountry(); // Select India
    addressPage.selectState();   // Select Andhra Pradesh
    addressPage.enterCity("Hyderabad");
    addressPage.enterFirstAddress("Madhapur");
    addressPage.enterPostalCode("500081");
    addressPage.enterPhoneNumber("7893904504");

    // Click Save
    addressPage.clickSave();

    // Assert Result
    if (addressPage.isAddressSaved()) {
        System.out.println("Address saved successfully!");
        Assert.assertTrue(true);
    } else {
        String error = addressPage.getAddressSaveErrorMessage();
        System.out.println("Address save failed: " + error);
        Assert.fail("Address save failed: " + error);
    }
}	
	
}
