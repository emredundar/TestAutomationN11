package testAutomation.n11.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testAutomation.n11.pages.*;

public class N11Tests extends BaseTest {
    private String selectedProductName;

    private static final String testUserEmail = "__USER_EMAIL__";
    private static final String testUserPassword = "__USER_PASSWORD__";
    private static final String searchTextToTest = "samsung";
    private static final String pageNumberToNavigate = "2";

    @Test(priority = 1, groups = {"Home"})
    public void homePageTest_VerifyHomePage() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToN11();
        homePage.isOnPage();
        Assert.assertTrue(homePage.isOnPage());
    }

    @Test(priority = 1, groups = {"Login"})
    public void loginTest_UserNamePassword() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loginToN11(testUserEmail, testUserPassword);
    }

    @Test(priority = 2, groups = {"Search"})
    public void searchProduct_VerifySearchFound() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.searchProduct(searchTextToTest);
        Assert.assertFalse(searchPage.isAnyResultFound());
    }

    @Test(priority = 3, groups = {"Search"})
    public void navigateToPage_VerifyPageNumber() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.navigateToPage(searchTextToTest, pageNumberToNavigate);
        Assert.assertEquals(searchPage.getPageNumber(), pageNumberToNavigate);
    }

    @Test(priority = 4, groups = {"Favorites"})
    public void addToFavorites_verifySelectedProduct() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.selectThirdProduct();

        ProductPage productPage = new ProductPage(driver, wait);
        productPage.checkRequiredFields();

        String[] selectedProduct = productPage.addToFavorites();
        selectedProductName = selectedProduct[0];
        String selectedProductIdToCheck = selectedProduct[1];

        FavoritesPage favoritesPage = new FavoritesPage(driver, wait);
        Assert.assertEquals(favoritesPage.getActualProductName(selectedProductIdToCheck), selectedProductName);
    }

    @Test(priority = 4, groups = {"Favorites"}, dependsOnMethods = "addToFavorites_verifySelectedProduct")
    public void deleteFromFavorites_verifyDeletion() {
        FavoritesPage favoritesPage = new FavoritesPage(driver, wait);
        favoritesPage.deleteFromFavorites();

        Assert.assertFalse(favoritesPage.isFavoriteDeleted(selectedProductName));
    }
}
