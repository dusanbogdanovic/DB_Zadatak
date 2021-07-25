package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.BasePage;
import pom.ProductsPage;

public class Shoppster extends BaseTest{

    @BeforeMethod
    @Parameters({"browser"})
    public void startTest(String browser){
        init(browser, 30);
    }

    @AfterMethod
    public void afterTest(){
        tearDown();
    }

    @Test
    @Parameters({"selectCategory", "category", "color", "filterMethod", "filter", "product", "productName"})
    public void products(String selectCategory, String category, String color, String filterMethod, String filter, String product, String productName) throws InterruptedException {
        driver.get("https://www.shoppster.com/sr-RS/");

        wdWait = new WebDriverWait(driver, 30);
        BasePage basePage = new BasePage(driver,wdWait);

        basePage.acceptCookies();
        basePage.selectCategory(selectCategory);

        ProductsPage productsPage = new ProductsPage(driver, wdWait);

        productsPage.setFilterCategory(category);
        pause(5);
        productsPage.setFilterColor(color);
        pause(5);
        productsPage.loadUnloadFilters(filterMethod);
        pause(1);
        productsPage.setFilterCheckbox(filterMethod, filter);
        pause(1);
        productsPage.selectProduct(product);

        String result = driver.findElement(By.cssSelector("h2.product__name")).getText();
        Assert.assertEquals(result, productName);



        //div[@class="plp__product-name" and contains(text(),'Daniel Wellington Ručni sat DW00100415')]
        //div[@class="plp__item plp__item--grid col-12 col-sm-6 col-md-4 col-xl-3 col-xxxl-2"]//div[contains(text(),'Daniel Wellington Ručni sat DW00100415')]
        //a[@class="vendor__hyperlink" and contains(text(),'Watch is Watch doo')]


        //1. Assertacije
        //2. Ceo test parametrizovan (xml testng)
        //2.b paralelno
        //2.c multy browser
        //3. Dodati anotacije za allure
        //4. 1 page koji nije vec pokriven

    }

    @Test

    public void signUp() throws InterruptedException {

    }

    //div[@class="mini-login__component"]//h5[@class="footer__headline--desktop" and contains(text(), 'Moj nalog')] - asertacija
}
