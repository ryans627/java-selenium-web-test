package com.ryans.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    // 账号的xpath
    private By usernameBy = By.xpath("//input[@placeholder='请输入用户名/手机/邮箱']");
    // 密码的xpath
    private By passwordBy = By.xpath("//input[@placeholder='请输入登录密码']");
    // 登录按钮的xpath
    private By loginBtnBy = By.xpath("//button[text()='登录']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clearInputs() {
        driver.findElement(usernameBy).clear();
        driver.findElement(passwordBy).clear();
    }

    public String login(String username, String password) throws InterruptedException {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBtnBy).click();
        return getNotificationMessage();
    }
}
