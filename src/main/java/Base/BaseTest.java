package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Data {
  @BeforeMethod
    public void openBrowser(){
        //String tarayici = "firefox";
        String tarayici = System.getProperty("browser");
        if (tarayici.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if (tarayici.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (tarayici.equals("edge"))
            driver = new EdgeDriver();


        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}




