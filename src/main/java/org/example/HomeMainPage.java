package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeMainPage {
    private By loginButton = By.xpath("//a[@href='/login']");
    private By sighUpButton = By.xpath("//a[@href='/signup']");
    private WebDriver driver;
    public HomeMainPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickLogin() {
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    public SignUpPage clickSighUp() {
        driver.findElement(loginButton).click();
        return new SignUpPage(driver);
    }


}
