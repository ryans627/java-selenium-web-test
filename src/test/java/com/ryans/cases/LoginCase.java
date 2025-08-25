package com.ryans.cases;

import com.ryans.pages.LoginPage;
import com.ryans.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginCase {
    private WebDriver driver;
    private LoginPage loginPage;

    // 会在这个测试类 所有测试方法执行前运行一次
    // 浏览器已经打开，URL已经定位到登录页面
    @BeforeMethod
    public void setUp() {
        driver = WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://116.62.63.211/shop/user/loginInfo.html");
        loginPage = new LoginPage(driver); // 在执行测试用例之前就实例化POM页面对象
    }

    @AfterMethod
    public void tearDown() {
        WebDriverUtils.closeDriver2s(driver);
    }

    // 定义数据提供者
    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][]{
                {"salewond", "123456", "登录成功"},
                {"aaaa1", "123456", "登录帐号不存在"},
                {"salewond", "999999", "密码错误"},
                {"salewond", "", "密码格式 6~18 个字符"},
                {"test", "12345", "密码格式 6~18 个字符"},
                {"", "123456", "请填写登录账号"},
        };
    }

    @Test(dataProvider = "loginData")
    // 使用数据驱动
    // 采用POM，测试用例只写业务方法
    public void testLogin(String username, String password, String expectedMsg) throws InterruptedException {
        String actualMsg = loginPage.login(username, password);
        // 断言
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
