import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private  WebDriver driver;

//    protected WebDriverWait wait = new WebDriverWait(driver, 15);


    public BasePage(WebDriver webDriver ){
        this.driver=webDriver;
    }

    public void goBasePage(String baseUrl){
         driver.get(baseUrl);
    }
    // implementation of "find" function with all types of locators

    /**
     *
     * @param locator By
     */
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    /**
     *
     * @param cssSelector String
     * @return
     */
    public WebElement find(String cssSelector){
        return find(By.cssSelector(cssSelector));
    }


    /**
     * wait
     */

//    public WebElement wait(By cssSelector){
//        WebDriverWait waitFor = new WebDriverWait(driver, 10);
//        return waitFor.until(ExpectedConditions.presenceOfElementLocated(cssSelector));
//    }


    // implementation of "click" function with all types of locators

    /**
     *
     * @param webElement WebElement
     */
    public void click(WebElement webElement){
        webElement.click();

    }

    /**
     *
     * @param locator By
     */
    public void click(By locator){
        click(find(locator));
    }

    /**
     *
     * @param cssSelector String
     */
    public void click(String cssSelector){
        click(find(cssSelector));
    }

    /**
     *
     * @param webElement WebElement
     * @param value
     */
    public void fill(WebElement webElement, String value){
        webElement.sendKeys(value);
    }

    /**
     *
     * @param locator By
     * @param value
     */
    public void fill(By locator, String value) {
        fill(find(locator), value);
    }

    /**
     *
     * @param cssLocator String
     * @param value
     */
     public void fill(String cssLocator, String value){
//        wait.until(ExpectedConditions.visibilityOf(find(cssLocator)));
        find(cssLocator).clear();
        find(cssLocator).sendKeys(value);
    }
    //*** Select

    public void select(String cssLocator, String value){
            click(find(cssLocator));
//            click(find(cssLocator).getText().contains(value));

    }

}
