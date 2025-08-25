package com.ryans.pages;

import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {
    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
