package testAutomation.n11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String loginButtonId = "loginButton";
    private static final String emailButtonId = "email";
    private static final String passwordButtonId = "password";

    public void loginToN11(String userEmail, String userPassword) {
        driver.findElement(By.id(emailButtonId)).clear();
        driver.findElement(By.id(emailButtonId)).sendKeys(userEmail);
        driver.findElement(By.id(passwordButtonId)).clear();
        driver.findElement(By.id(passwordButtonId)).sendKeys(userPassword);
        driver.findElement(By.id(loginButtonId)).click();
    }
}