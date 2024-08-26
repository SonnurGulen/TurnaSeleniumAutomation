package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BaseLibrary {
    @Step("Check Home Content card points ")
    public HomePage clickHomeContents() throws InterruptedException {
        String cardTitle = driver.findElement(By.cssSelector("[class='home__properties__item__title']")).getText();
        Assert.assertEquals(homecontentcardtitle1, cardTitle);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[class='home__properties__item__title']")).click();
        screenshot();
        String pageTitle = driver.findElement(By.cssSelector("[class='page-stepper__item__info__primary']")).getText();
        Assert.assertEquals(homecontentcard1, pageTitle);
        return this;
    }

    @Step("Check Home campaign cards ")
    public HomePage checkHomeCampaigns() {
        List<WebElement> cards = driver.findElements(By.cssSelector("[class='home__campaign__item__content']"));
        Assert.assertEquals(cards.size(), 4, "There should be exactly 4 cards on the homepage.");
        for (WebElement card : cards) {
            WebElement photo = card.findElement(By.cssSelector("[class='home__campaign__item__content__img']"));
            Assert.assertTrue(photo.isDisplayed(), "The card should contain a photo.");
            WebElement title = card.findElement(By.cssSelector("[class='home__campaign__item__content__header']"));
            Assert.assertTrue(title.isDisplayed(), "The card should contain a title.");
        }
        screenshot();
        return this;
    }

    @Step("Click more Home campaign cards and choose one with most days")
    public HomePage clickHomeCampaign() throws InterruptedException {
     String currentUrl = driver.getCurrentUrl();
        driver.findElement(By.cssSelector("[class='all-campaigns-btn']")).click();
        Thread.sleep(2000);
        List<WebElement> cards = driver.findElements(By.xpath("//*[@id=\"panel1\"]/div/div/div[2]"));
        int randomIndex = (int) (Math.random() * cards.size());
        cards.get(randomIndex).click();
        String newUrl = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertNotEquals(newUrl, currentUrl, "The URL did not change after clicking the campaign card.");
        return this;
    }

}
