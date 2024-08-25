package Base;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Data{
    @BeforeMethod

    public void openBrowser(){
     ChromeOptions op = new ChromeOptions();
        op.addArguments("--disable-notifications");
        driver= new ChromeDriver(op);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
