package Base;
import org.openqa.selenium.WebDriver;

public class Data {
    public static WebDriver driver;
   // public String url = ;
      public String url = System.getProperty("https://www.turna.com/");
    public String email="glnsnnr@gmail.com";
    public String password="S.G.123";
    public String namecheck="Sonnur gülen";
    public String emailErrorMessage= "Geçerli bir e-posta adresi girilmelidir.";
    public String passwordErrorMessage="E-mail veya şifre doğru değil. Şifrenizi hatırlamıyorsanız Şifreni mi unuttun? linkine tıklayarak yeni şifrenizi belirleyebilirsiniz.";
    public String passwordErrorMessageMax="Şifre uzunluğu 21 karakterden fazla olamaz.";
    public String passwordErrorMessageMin="Şifre en az 3 karakter uzunluğunda olmalı.";
    public  String homecontentcardtitle1 ="Kart puanı";
    public String homecontentcard1="Kartınızı Sorgulayın (Kullanıcı Girişi Yapmak Zorunludur!)";

}
