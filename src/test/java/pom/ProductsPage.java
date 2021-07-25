package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends CommonActions{

    WebDriver driver;
    WebDriverWait webDriverWait;

    public ProductsPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(driver, this);
    }

    public void setFilterCheckbox(String filterMethod, String filter) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//a[@class='cx-facet-header-link' and contains(text(),'"+filterMethod+"')]/../..//li//span[contains(text(),'"+filter+"')]/../input")));
    }
    public void setFilterColor(String color) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//a[@class='cx-facet-header-link' and contains(text(),'Boja')]/../..//li/div[@title='"+color+"']")));
    }
    public void setFilterCategory(String category) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//a[@class='cx-facet-header-link' and contains(text(),'Kategorije')]/../..//ul//a[contains(text(),'"+category+"')]")));
    }
    public void loadUnloadFilters(String filterMethod) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//a[@class='cx-facet-header-link' and contains(text(),'"+filterMethod+"')]/../..//li[last()]")));
    }
    public void selectProduct(String product) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//div[@class=\"plp__product-name\" and contains(text(),'"+product+"')]")));
    }
}
