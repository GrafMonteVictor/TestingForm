package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeMainPage {
    private By loginButton = By.xpath("//a[@href='/login']");
    private By sighUpButton = By.xpath("//a[@href='/signup']");
    private By homeButton = By.xpath("//a[@href='/']");
    private WebDriver driver;
    public HomeMainPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickLogin() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    public SignUpPage clickSignUp() {
        driver.findElement(sighUpButton).click();
        return new SignUpPage(driver);
    }
    public HomeMainPage clickHome() {
        driver.findElement(homeButton).click();
        return this;
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

}
