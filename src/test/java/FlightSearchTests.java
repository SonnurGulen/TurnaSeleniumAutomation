import Base.BaseTest;
import Pages.FlighSearchPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class FlightSearchTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    FlighSearchPage flighSearchPage = new FlighSearchPage();


    @Test(description = "Successfully search for fligths and choose a flight")
    public void searchFlight() throws InterruptedException {
        loginPage
                .goToLoginPage()
                .fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();
        Thread.sleep(3000);
        flighSearchPage
                .chooseDate()//This Step won't work if it is not called first.
                .enterDepatureCity();
        Thread.sleep(2000);
        flighSearchPage
                .enterDesCity()
                .clickSearchButton();
        Thread.sleep(2000);
        flighSearchPage
                .choosefirstFlight();
    }


}
