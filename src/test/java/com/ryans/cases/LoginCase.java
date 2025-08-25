package com.ryans.cases;

import com.ryans.pages.LoginPage;
import com.ryans.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginCase {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        // 基础元素定位
        driver = WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverUtils.closeDriver2s(driver);
    }

    @Test
    // 采用POM，测试用例只写业务方法
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        String message = loginPage.loginSuccess("salewond", "123456");
        Assert.assertEquals(message, "登录成功");
    }
}
