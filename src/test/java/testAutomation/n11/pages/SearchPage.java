package testAutomation.n11.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String searchFieldId = "searchData";
    private static final String searchButtonCss = "a.searchBtn";

    public void searchProduct(String searchText) {
        driver.findElement(By.id(searchFieldId)).click();
        driver.findElement(By.id(searchFieldId)).clear();
        driver.findElement(By.id(searchFieldId)).sendKeys(searchText);
        driver.findElement(By.cssSelector(searchButtonCss)).click();
    }

    public boolean isAnyResultFound() {
        return (driver.findElements(By.className("notFoundContainer")).size() != 0);
    }

    public void navigateToPage(String searchText, String pageNumber) {
        String pageURL = baseURL + "/arama?q=" + searchText + "&pg=" + pageNumber;
        driver.navigate().to(pageURL);
    }

    public String getPageNumber() {
        return driver.findElement(By.cssSelector("div.pageInfo > input[name=\"currentPage\"]")).getAttribute("value");
    }

    public void selectThirdProduct() {
        String selectedProductLink = driver.findElement(By.cssSelector("#view > ul > li:nth-child(3) > div > div > a[href]")).getAttribute("href");
        driver.get(selectedProductLink);
    }
}