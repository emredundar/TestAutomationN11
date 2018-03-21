package testAutomation.n11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String favoritesLinkText = "Favorilerim";
    private static final String getWishListButtonId = "getWishList";
    private static final String productIdSelector = "data-productid";
    private static final String requiredSelectionField = "select[data-validation='required']";

    public void checkRequiredFields() {
        try {
            new Select(driver.findElement(By.cssSelector(requiredSelectionField))).selectByIndex(1);
        } catch (NoSuchElementException ignored) {
        }
    }

    public String[] addToFavorites() {
        driver.findElement(By.id(getWishListButtonId)).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(favoritesLinkText)));
        driver.findElement(By.linkText(favoritesLinkText)).click();

        String selectedProduct[] = new String[2];
        selectedProduct[0] = driver.findElement(By.cssSelector("h1[class='proName']")).getText();
        selectedProduct[1] = driver.findElement(By.id(getWishListButtonId)).getAttribute(productIdSelector);
        return selectedProduct;
    }
}
