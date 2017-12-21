import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RoujePageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        mainPage = new MainPage(driver);


    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @Test
    public void test(){
        mainPage.goBasePage();
        mainPage.fillSearch("Moschino");
        mainPage.clickOnSearchButton();
        assertTrue(mainPage.getTextAfterSearch().contains("Search Results For"), "Assertion failed!");
        mainPage.selectCombo("Price");

    }



}
