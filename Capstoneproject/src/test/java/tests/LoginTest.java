package tests;

import core.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void loginTestValidCredentials1() throws InterruptedException {
		// Go to login page
		HomePage home = new HomePage(driver);
		home.clickLogin();

		LoginPage login = new LoginPage(driver);
		login.enterEmail("hemanjalimuli@gmail.com");
		login.enterPassword("123123123");
		login.clickLogin();

		// Check login result
		if (login.isLoginSuccessful()) {
			System.out.println("Login successful! My Account link is visible.");
			Assert.assertTrue(true); // test passes
		} else {
			String errorMsg = login.getLoginErrorMessage();
			System.out.println("Login failed with error: " + errorMsg);
			Assert.assertFalse(true, "Login failed: " + errorMsg); // fail the test
		}
	}

	@Test
	public void loginTestValidCredentials() throws InterruptedException {
	    LoginPage login = new LoginPage(driver);
	    login.enterEmail("hemanjalimuli@gmail.com");
	    login.enterPassword("123123123");
	    login.clickLogin();

	    Assert.assertTrue(login.isLoginSuccessful(), "Expected login to succeed!");
	}

	    // Check login result
	
	@Test
	public void loginTestInvalidEmail() {
	    LoginPage login = new LoginPage(driver);
	    login.enterEmail("Invalid@gmail.com");
	    login.enterPassword("123123123");
	    login.clickLogin();

	    Assert.assertFalse(login.isLoginSuccessful(), "Login succeeded with invalid email!");
	    Assert.assertTrue(login.getLoginErrorMessage().contains("Login was unsuccessful"));
	}

	    // Check login result

	@Test
	public void loginTestBlankCredentials() throws InterruptedException {
	    HomePage home = new HomePage(driver);
	    home.clickLogin();

	    LoginPage login = new LoginPage(driver);
	    login.enterEmail("");   // blank
	    login.enterPassword(""); // blank
	    login.clickLogin();

	    String errorMsg = login.getLoginErrorMessage();
	    System.out.println("Error for blank login: " + errorMsg);

	    Assert.assertTrue(
	        errorMsg.contains("Please enter your email") || 
	        errorMsg.contains("Login was unsuccessful"),
	        "Expected validation for blank credentials but got: " + errorMsg
	    );
	}


}