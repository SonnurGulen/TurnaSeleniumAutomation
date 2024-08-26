
import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;

import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    HomePage homePage=new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "Check title of the first card and click")
    public void checkcards() throws InterruptedException {
        loginPage
                .goToLoginPage()
                .fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();
        Thread.sleep(3000);
        homePage.clickHomeContents();
    }

    @Test(description = "Check contents of the cards")
    public void checkCampaigns() throws InterruptedException {
        loginPage
                .goToLoginPage()
                .fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();
        Thread.sleep(3000);
        homePage.checkHomeCampaigns();
    }

    @Test(description = "Check contents of the cards")
    public void findCampaign() throws InterruptedException {
        loginPage
                .goToLoginPage()
                .fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();
        Thread.sleep(3000);
        homePage.clickHomeCampaign();
    }
}

