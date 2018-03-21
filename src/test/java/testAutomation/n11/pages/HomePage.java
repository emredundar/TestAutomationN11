package testAutomation.n11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String loginButtonClass = "btnSignIn";
    private static final String testPageTitle = "n11.com - Alışverişin Uğurlu Adresi";

    public void goToN11() {
        driver.get(baseURL);
    }

    public boolean isOnPage() {
        return driver.getTitle().contentEquals(testPageTitle);
    }

    public void goToLoginPage() {
        driver.get(baseURL);
        driver.findElement(By.className(loginButtonClass)).click();
    }
}