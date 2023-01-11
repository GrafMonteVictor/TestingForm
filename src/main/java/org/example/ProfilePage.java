package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;
    private By profileButton = By.xpath("//*[@href='/profile']");
    private By logoutButton = By.xpath("//*[@href='/logout']");
    private By homeButton = By.xpath("//*[@href='/']");
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }
    public HomeMainPage clickLogout() {
        driver.findElement(logoutButton).click();
        return new HomeMainPage(driver);
    }

    public ProfilePage clickProfile() {
        driver.findElement(profileButton).click();
        return this;
    }
    public HomeMainPage clickHome() {
        driver.findElement(homeButton).click();
        return new HomeMainPage(driver);
    }
    public String getURL() {
        return driver.getCurrentUrl();
    }
}
