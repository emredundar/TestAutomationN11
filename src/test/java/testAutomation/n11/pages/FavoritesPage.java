package testAutomation.n11.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class FavoritesPage extends BasePage {

    public FavoritesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String deleteButtonClass = "deleteProFromFavorites";

    public String getActualProductName(String selectedProductId) {
        driver.get(baseURL + "/hesabim/favorilerim");
        String productSelector = "#p-" + selectedProductId;
        return driver.findElement(By.cssSelector(productSelector + " > div > a > h3")).getText();
    }

    public void deleteFromFavorites() {
        driver.findElement(By.className(deleteButtonClass)).click();
    }

    public boolean isFavoriteDeleted(String selectedProductName) {
        List<String> favoriteBasket = new ArrayList<>();
        List<WebElement> favoriteProducts = driver.findElements(By.xpath("//*[@class='productTitle']/p/a"));
        for (WebElement productTitle : favoriteProducts) {
            String productName = productTitle.getText();
            favoriteBasket.add(productName);
        }
        return favoriteBasket.contains(selectedProductName);
    }
}