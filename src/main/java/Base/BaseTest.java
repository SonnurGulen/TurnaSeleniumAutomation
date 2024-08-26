package Base;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Data{
    @BeforeMethod

    public void openBrowser(){
        String broserVar = System.getProperty("browser");
        if (broserVar.equals("chrome")) {
            ChromeOptions op = new ChromeOptions();
            op.addArguments("--disable-notifications");
            driver= new ChromeDriver(op);
        }
        else if (broserVar.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (broserVar.equals("edge"))
            driver = new EdgeDriver();
    }

        driver.get(url);
   
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.cssSelector("[class*='snackbar-btn-reject']")).click();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}
