package com.ryans.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private String loginPageURL = "http://116.62.63.211/shop/user/loginInfo.html";
    // 账号的xpath
    private By usernameBy = By.xpath("//input[@placeholder='请输入用户名/手机/邮箱']");
    // 密码的xpath
    private By passwordBy = By.xpath("//input[@placeholder='请输入登录密码']");
    // 登录按钮的xpath
    private By loginBtnBy = By.xpath("//button[text()='登录']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void navigateToLoginPage() {
        driver.get(loginPageURL);
    }

    public String loginSuccess(String username, String password) throws InterruptedException {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBtnBy).click();
        return getNotificationMessage();
    }
}
