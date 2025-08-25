package com.ryans.cases;

import com.ryans.pages.IndexPage;
import com.ryans.pages.LoginPage;
import com.ryans.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

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

    // @Test
    // public void testLogin() {
    //     // Step 1: Click on login button
    //     driver.findElement(By.xpath("//a[text()='登录']")).click();
    //     // Step 2: Assert actual URL equals to expected URL
    //     String actualURL = driver.getCurrentUrl().toLowerCase();
    //     System.out.println(actualURL);
    //     String expectedURL = "http://116.62.63.211/shop/user/loginInfo.html".toLowerCase();
    //     Assert.assertEquals(actualURL, expectedURL);
    //     // Step 3: Fill in the username field
    //     driver.findElement(By.xpath("//input[@placeholder='请输入用户名/手机/邮箱']")).sendKeys("ltqiu251");
    //     // Step 4: Fill in the password field
    //     driver.findElement(By.xpath("//input[@placeholder='请输入登录密码']")).sendKeys("123456");
    //     // Step 5: Click on the login button
    //     driver.findElement(By.xpath("//button[text()='登录']")).click();
    //
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    //     WebElement messageBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='prompt-msg']")));
    //     System.out.println("messageBar: " + messageBar);
    //     String actualMessage = messageBar.getText();
    //     Assert.assertEquals(actualMessage, "登录成功");
    // }

    @Test
    // 采用POM，测试用例只写业务方法
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        String message = loginPage.loginSuccess("salewond", "123456");
        Assert.assertEquals(message, "登录成功");
    }
}
