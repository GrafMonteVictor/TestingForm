package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private By emailField = By.xpath("//input[@name='email']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By rememberMeCheckBox = By.xpath("//label[text()[contains(.,'Remember me')]]");
    private By loginButton = By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage inputEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public LoginPage inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public ProfilePage clickLogin() {
        driver.findElement(loginButton).click();
        return new ProfilePage(driver);
    }
    public LoginPage clickRememberMeCheckbox() {
        driver.findElement(rememberMeCheckBox).click();
        return this;
    }
}
