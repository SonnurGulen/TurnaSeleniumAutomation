package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BaseLibrary {

    @Step("Go to login Modal ")
    public LoginPage goToLoginPage() {
        driver.findElement(By.xpath("//*[@id=\"login-link\"]/a")).click();
        return this;
    }

    @Step("Fill email")
    public LoginPage fillEmail(String str) {
        driver.findElement(By.cssSelector("[id='txtSignInEmail']")).sendKeys(str);
        return this;
    }

    @Step("Fill password")
    public LoginPage fillPassword(String str) {
        driver.findElement(By.cssSelector("[id='txtSignInPassword']")).sendKeys(str);
        return this;
    }

    @Step("Click Login Button")
    public LoginPage clickLoginButton() {
        driver.findElement(By.cssSelector("[id='btnSignIn']")).click();
        return this;
    }

    @Step("Validate Login")
    public LoginPage validateLogin() throws InterruptedException {
        Thread.sleep(3000);
        String profileName = driver.findElement(By.cssSelector("[class='user-profile__name']")).getText();
        Assert.assertEquals(profileName, namecheck);
        screenshot();
        return this;
    }

    @Step("Fill email wrong type")
    public LoginPage emailErrorCheck() {
        String errorMessage = driver.findElement(By.cssSelector("[ class='invalid']")).getText();
        Assert.assertEquals(errorMessage, emailErrorMessage);
        screenshot();
        return this;
    }

    @Step("Wrong password or Email")
    public LoginPage fillEmailOrPasswordwrongCheck(){
        String errorMessage = driver.findElement(By.cssSelector("[ id='error-content']")).getText();
        Assert.assertEquals(errorMessage, passwordErrorMessage);
       screenshot();
        return this;
    }

    @Step("Wrong password Max")
    public LoginPage wrongPasswordMax(){
        String errorMessage = driver.findElement(By.cssSelector("[ id='error-content']")).getText();
        Assert.assertEquals(errorMessage, passwordErrorMessageMax);
        screenshot();
        return this;
    }
    @Step("Wrong password Min")
    public LoginPage wrongPasswordMin(){
        String errorMessage = driver.findElement(By.cssSelector("[ id='error-content']")).getText();
        Assert.assertEquals(errorMessage, passwordErrorMessageMin);
        screenshot();
        return this;
    }
}
