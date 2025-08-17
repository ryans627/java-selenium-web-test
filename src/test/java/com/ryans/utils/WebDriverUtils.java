package com.ryans.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverUtils {
    public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;
        if ("chrome".equals(browserType)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();
        } else if ("edge".equals(browserType)) {
            System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver");
            driver = new EdgeDriver();
        }
        return driver;
    }

    public static void closeDriver2s(WebDriver driver) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
