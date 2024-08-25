package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Calendar;
import java.util.List;

public class FlighSearchPage extends BaseLibrary {

    @Step("Enter departure city ")
    public void enterDepatureCity() {
        driver.findElement(By.cssSelector("[next-element-id='flight_origincode']")).clear();
        driver.findElement(By.cssSelector("[next-element-id='flight_origincode']")).sendKeys("Anka");
    }

    @Step("Enter destination city ")
    public FlighSearchPage enterDesCity() {
        //driver.findElement(By.cssSelector("[n next-element-id='flight_destcode'']")).clear();
        driver.findElement(By.cssSelector("[ next-element-id='flight_destcode']")).sendKeys("Tokyo");
        return this;
    }

    @Step("Pick Date")
    public FlighSearchPage chooseDate() throws InterruptedException {
        driver.findElement(By.xpath("//input[contains(@id, 'dp')]")).click();
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        if (day > 26) {
            cal.add(Calendar.MONTH, 1);
            month = cal.get(Calendar.MONTH);
            cal.set(Calendar.DAY_OF_MONTH,1);
        } else if (month > 10) {
            cal.add(Calendar.YEAR, 1);
            year = cal.get(Calendar.YEAR);
        } else {
            cal.add(Calendar.DAY_OF_MONTH, 2);
            cal.add(Calendar.MONTH, 1);
            day = cal.get(Calendar.DAY_OF_MONTH);
            month = cal.get(Calendar.MONTH);
        }
        driver.findElement(By.xpath("//td[@data-month='" + month + "' and @data-year='" + year + "']/a[text()='" + day + "']")).click();
        return this;
    }

    @Step("Click Search button")
    public void clickSearchButton(){
        driver.findElement(By.id("btnSearch")).click();
    }

    @Step("Chose a flight with last space")
    public FlighSearchPage choosefirstFlight(){
       List<WebElement> btns= driver.findElements(By.cssSelector("[class='bt-choose']"));
       btns.get(1).click();
       return this;
    }
}
