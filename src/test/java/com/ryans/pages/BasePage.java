package com.ryans.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected String getNotificationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement messageBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='prompt-msg']")));
        String notificationMessage = messageBar.getText();
        System.out.println("notification Message: " + notificationMessage);
        return notificationMessage;
    }
}
