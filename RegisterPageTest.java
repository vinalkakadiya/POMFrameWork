package com.demo.nopcommerce.test;

import com.demo.nopcommerce.base.BasePage;
import com.demo.nopcommerce.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterPageTest {
    BasePage basePage;
    WebDriver driver;
    Properties prop;
    RegisterPage registerPage;

    @BeforeTest
    public void openBrowser() {
        basePage = new BasePage();
        prop = basePage.initialiseProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        registerPage = new RegisterPage(driver);
    }

    @Test(priority = 1)
    public void verifyRegisterPageTitleTest() throws InterruptedException {
        Assert.assertEquals(registerPage.getRegisterPageTitle(), "nopCommerce demo store. Register", "Registerpage Title not mateh");

    }

    @Test(priority = 2)
    public void RegisterTest() throws InterruptedException {
        registerPage.doRegister(prop.getProperty("FirstName"), prop.getProperty("LastName"), prop.getProperty("day"), prop.getProperty("month"),
                prop.getProperty("year"), prop.getProperty("Email"), prop.getProperty("Company"), prop.getProperty("password"), prop.getProperty("ConfirmPassword"));

    }
    @AfterTest
    public void tearDown(){ driver.quit();}
    }