package com.demo.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Year;

public class RegisterPage {
    WebDriver driver;
    //1Create your page object/object repository in the form of by Locators.
    //  By register = By.xpath("//a[@class='ico-register'");
    By genderfemale = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By Day = By.cssSelector("select[name='DateOfBirthDay']");
    By Month = By.xpath("//select[@name='DateOfBirthMonth']");
    By year = By.xpath("//select[@name='DateOfBirthYear']");
    By EmailId = By.id("Email");
    By CompanyName = By.id("Company");
    By newsletter = By.id("Newsletter");
    By Password = By.id("Password");
    By confirmpassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    //2. Create constructor of page class.
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page actions/page methods.
    public String getRegisterPageTitle() throws InterruptedException {
        String RPTitle = driver.getTitle();
        Thread.sleep(4000);
        System.out.println("Register page title is" + RPTitle);
        return RPTitle;
    }

    public boolean VerifyRegisterButton() throws InterruptedException {
        Thread.sleep(4000);
        return driver.findElement(registerButton).isDisplayed();
    }

    public void  doRegister(String FirstName, String LastName, String day, String month, String Year, String Email,
                                   String Company, String password, String ConfirmPassword) throws InterruptedException {
     //   driver.findElement(register).click();
        driver.findElement(genderfemale).click();
        driver.findElement(firstName).sendKeys(FirstName);
        driver.findElement(lastName).sendKeys(LastName);
        Thread.sleep(3000);
        driver.findElement(Day).sendKeys(day);
        driver.findElement(Month).sendKeys(month);
        driver.findElement(year).sendKeys(Year);
        Thread.sleep(3000);
        driver.findElement(EmailId).sendKeys(Email);
        Thread.sleep(3000);
        driver.findElement(CompanyName).sendKeys(Company);
        driver.findElement(newsletter).click();
        driver.findElement(Password).sendKeys(password);
        driver.findElement(confirmpassword).sendKeys(ConfirmPassword);
        driver.findElement(registerButton).click();
        System.out.println("Credentials are" + FirstName + "" + LastName + "" + Email + "" + day + "" +
                month + "" + Company + "" + password + "" +ConfirmPassword);

    }


}

