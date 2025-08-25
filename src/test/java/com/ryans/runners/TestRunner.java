package com.ryans.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",         // 1) feature 位置
        glue = {"com.ryans.steps"},                                 // 2) glue 包路径（可多个）
        plugin = {"pretty", "html:target/cucumber.html"}, // 3) 报告
        monochrome = true,
        tags = "@smoke or @regression"                    // 4) 可选：按标签筛选
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
