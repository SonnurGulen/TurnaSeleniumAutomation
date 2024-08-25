import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(description = "successful login")
    public void loginSuccessful() throws InterruptedException {
        loginPage
                .goToLoginPage()
                .fillEmail(email)
                .fillPassword(password)
                .clickLoginButton()
                .validateLogin();
    }

    @Test(description = "Login with wrong email format")
    public void loginWrongFormatEmail()  {
        loginPage
                .goToLoginPage()
                .fillEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .fillPassword(password)
                .clickLoginButton()
                .emailErrorCheck();
    }

    @Test(description = "Login with wrong email")
    public void loginWrongEmail() {
        loginPage
                .goToLoginPage()
                .fillEmail("ssdds@gmail.com")
                .fillPassword(password)
                .clickLoginButton()
                .fillEmailOrPasswordwrongCheck();
    }

    @Test(description = "Login with maximum password character")
    public void loginMax() {
        loginPage
                .goToLoginPage()
                .fillEmail(email)
                .fillPassword("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .clickLoginButton()
                .wrongPasswordMax();
    }

    @Test(description = "Login with minimum password character")
    public void loginMin() {
        loginPage
                .goToLoginPage()
                .fillEmail(email)
                .fillPassword("aa")
                .clickLoginButton()
                .wrongPasswordMin();
    }

}
