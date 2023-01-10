package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final By emailLocator = By.xpath("//input[@name='email']");
    private final By nameLocator = By.xpath("//input[@name='name']");
    private final By passwordLocator = By.xpath("//input[@name='password']");
    private final By signUpButtonLocator = By.xpath("//button[@class='button is-block is-info is-large is-fullwidth']");
    private final WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    //Методы
        //3 метода для нахождения и вбивания данных
        //метод .click()

    public void inputEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }
    public void inputName(String name) {
        driver.findElement(nameLocator).sendKeys(name);
    }
    public void inputPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void clickSignUp() {
        driver.findElement(signUpButtonLocator).click();
    }

}
