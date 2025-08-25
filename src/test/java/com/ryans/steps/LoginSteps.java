package com.ryans.steps;

import com.ryans.pages.LoginPage;
import com.ryans.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private String actualMessage;

    @Before
    public void setUp() {
        driver = WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        WebDriverUtils.closeDriver2s(driver);
    }

    @Given("user has opened login page")
    public void user_is_on_login_page() {
        driver.get("http://116.62.63.211/shop/user/loginInfo.html");
    }

    @When("user types in username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("user clicks on login button")
    public void user_clicks_login_button() {
        actualMessage = loginPage.clickLoginButton();
    }

    @Then("system should display {string}")
    public void system_should_display_message(String expectedMsg) {
        Assert.assertEquals(actualMessage, expectedMsg);
    }
}
