package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.BasePage;
import pom.ProductsPage;
import pom.SignUpPage;

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


    @Test (description = "Product search")
    @Description("Pretraga proizvoda")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("EP001")
    @Feature("F001")
    @Story("S001")
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
    }

    @Test (description = "Sign Up")
    @Description("Registracija korisnika")
    @Parameters({"ime", "prezime", "email", "password", "dan", "mesec", "godina", "pol", "potvrda", "account"})
    public void signUp(String ime, String prezime, String email, String password, String dan, String mesec, String godina, String pol, String potvrda, String account) throws InterruptedException {
        driver.get("https://www.shoppster.com/sr-RS/");

        wdWait = new WebDriverWait(driver, 30);
        BasePage basePage = new BasePage(driver,wdWait);

        basePage.acceptCookies();
        basePage.clickLoginButton();

        SignUpPage signUpPage = new SignUpPage(driver, wdWait);

        signUpPage.clickSignUpButton();
        pause(5);
        signUpPage.selectCustomerType();
        pause(5);
        signUpPage.insertFirstName(ime);
        pause(1);
        signUpPage.insertLastName(prezime);
        pause(1);
        signUpPage.insertEmail(email);
        pause(1);
        signUpPage.insertPassword(password);
        pause(1);
        signUpPage.confirmPassword(password);
        pause(1);
        signUpPage.insertBirthDay(dan);
        pause(1);
        signUpPage.clickMonth();
        pause(1);
        signUpPage.selectMonth(mesec);
        pause(1);
        signUpPage.insertYear(godina);
        pause(1);
        signUpPage.selectGender(pol);
        pause(1);
        signUpPage.confirm(potvrda);
        signUpPage.submit();
        pause(5);

        String signedIn = driver.findElement(By.xpath("//span[@class=\"mini-login__greeting\"]")).getText();
        Assert.assertEquals(signedIn, account);

    }

}