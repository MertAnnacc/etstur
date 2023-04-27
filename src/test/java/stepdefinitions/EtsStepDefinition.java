package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EtsTurPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;


public class EtsStepDefinition {

    EtsTurPage etsTurPage = new EtsTurPage();

    Actions actions = new Actions(Driver.getDriver());


    @Given("Kullanıcı etstur.com adresine gider.")
    public void kullanıcı_etstur_com_adresine_gider() {
        // Site adresine gitme
        Driver.getDriver().get(ConfigReader.getProperty("Url"));

    }


    @Then("Sitenin title  gorur ve dogru sitede oldugunu anlar.")
    public void siteninTitleGorurVeDogruSitedeOldugunuAnlar() {

        // Site erişilebilirliği doğrulama
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Tatil";

        ReusableMethods.bekle(3);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @And("Sayfayı kapatır.")
    public void sayfayıKapatır() {
        // Sayfa kapatma
        Driver.getDriver().quit();
    }

    @Then("Giris yap dropdown menusunu gorur.")
    public void girisYapDropdownMenusunuGorur() {
        ReusableMethods.bekle(2);

        // Giriş sekmesinin göründüğünü doğrulama
        Assert.assertTrue(etsTurPage.girisDropdownMenu.isDisplayed());


    }

    @Then("Giris yap linkine tıklar.")
    public void girisYapLinkineTıklar() {

        // Dropdown menü tıklama
        etsTurPage.girisDropdownMenu.click();

        // Dropdown menüdeki giriş yap butonuna tıklama
        etsTurPage.girisLink.click();
        ReusableMethods.bekle(2);
    }

    @And("E-mail ve şifre textbox gorur.")
    public void eMailVeŞifreTextboxGorur() {
        // Email görünürlüğü doğrulama
        Assert.assertTrue(etsTurPage.emailTextBoxLink.isDisplayed());

        // Şifre görünürlüğü doğrulama
        Assert.assertTrue(etsTurPage.passwordTextBoxLink.isDisplayed());
        ReusableMethods.bekle(2);
    }

    @Then("E-mail ve sifre girer.")
    public void eMailVeSifreGirer() {
        ReusableMethods.bekle(2);
        // Email textboxını doldurma
        etsTurPage.emailTextBoxLink.sendKeys(ConfigReader.getProperty("UserName"));
        ReusableMethods.bekle(1);

        // Şifre textboxını doldurma
        etsTurPage.passwordTextBoxLink.sendKeys(ConfigReader.getProperty("Password"));
    }

    @Then("Basarılı bir sekilde giris yapabildigini gorur.")
    public void basarılıBirSekildeGirisYapabildiginiGorur() {

       // Giriş butonu tıklama
       etsTurPage.girisButton.click();
       ReusableMethods.bekle(2);

       // Pop up kapatma
       etsTurPage.girisCloseButton.click();

       // Giriş yapılabildiği doğrulama
       etsTurPage.userProfileLink.click();

       // Hesabım görünürlüğünü doğrulama
       Assert.assertTrue(etsTurPage.hesabımLink.isDisplayed());
       ReusableMethods.bekle(2);

    }

    @And("Anasayfa bulunan,Nereye gitmek istersin?,Gidis tarihi,Donüs tarihi,kişi sayısı alanlarını gorur.")
    public void anasayfaBulunanNereyeGitmekIstersinGidisTarihiDonüsTarihiKişiSayısıAlanlarınıGorur() {
        ReusableMethods.bekle(1);

        // Ana sayfa ekranını doğrulama
        Assert.assertTrue(etsTurPage.neresiBox.isDisplayed());
        Assert.assertTrue(etsTurPage.gidisLink.isDisplayed());
        Assert.assertTrue(etsTurPage.donusLink.isDisplayed());
        Assert.assertTrue(etsTurPage.kisiSayiLink.isDisplayed());
        ReusableMethods.bekle(1);

    }

    @Then("Bu alanlarda seçmlerini yapar ve ara butonuna basar.")
    public void buAlanlardaSeçmleriniYaparVeAraButonunaBasar() {
        // Nereye gitmek istersin kutusu tıklama
        etsTurPage.neresiBox.click();
        ReusableMethods.bekle(1);

        // Erken rezervasyon otel tıklama
        etsTurPage.rezervasyonOtelLink.click();
        ReusableMethods.bekle(1);

        // Gidiş tarihi kutusu tıklama
        etsTurPage.gidisLink.click();
        ReusableMethods.bekle(1);

        // Gidiş tarih seçme
        etsTurPage.gidisTarihLink.click();
        ReusableMethods.bekle(1);

        // Dönüş tarih seçme
        etsTurPage.donusTarihLink.click();
        ReusableMethods.bekle(1);

        // Ara butonuna tıklama
        etsTurPage.araButton.click();
    }

    @Then("İlgili sayfaya gittiğini gorur.")
    public void ilgiliSayfayaGittiğiniGorur() {

        // Doğru sayfaya gidildiğinin kontrolü
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Erken";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.bekle(2);


    }

    @And("İstedigi oteli seçer ve açılan sayfada istedigi odayı seçip odayı seç linkine tıklar.")
    public void istedigiOteliSeçerVeAçılanSayfadaIstedigiOdayıSeçipOdayıSeçLinkineTıklar() {

        // İlk sayfanın window handle değerini alma
        String ilkSayfaHandle = Driver.getDriver().getWindowHandle();

        // Otel seçimi
        etsTurPage.hotelNameLink.click();

        // Açılan yeni sekmenin handle değerini bulmak
        Set<String> tumWHDegerleriSeti= Driver.getDriver().getWindowHandles();

        String ikinciSayfaWHD="";
        for (String eachWhd: tumWHDegerleriSeti
        ) {
            if (!eachWhd.equals(ilkSayfaHandle)){
                ikinciSayfaWHD=eachWhd;
            }
        }

        // Yeni sekmenin WH değeri
        Driver.getDriver().switchTo().window(ikinciSayfaWHD);
        ReusableMethods.bekle(2);


        actions
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        ReusableMethods.bekle(2);

        // Oda seçimi
        etsTurPage.odaSecLink.click();

    }

    @Then("Misafir bilgileri ekranını gorur.")
    public void misafirBilgileriEkranınıGorur() {
        // Doğru sayfaya gidildiğinin kontrolü
        Assert.assertTrue(etsTurPage.misafirLink.isDisplayed());
    }

    @Then("Bu bölümdeki kısımları doldurulur ve ödeme adımına ilerle butonuna basar.")
    public void buBölümdekiKısımlarıDoldurulurVeÖdemeAdımınaIlerleButonunaBasar() {
        ReusableMethods.bekle(2);

        // Müşteri bilgileri ekranı bilgi girişi ve
        etsTurPage.isimTextBoxLink.sendKeys(ConfigReader.getProperty("isim"));
        etsTurPage.soyIsimTextBoxLink.sendKeys(ConfigReader.getProperty("soyisim"));
        etsTurPage.epostaTextBoxLink.sendKeys(ConfigReader.getProperty("eposta"));
        etsTurPage.telefonTextBoxLink.sendKeys(ConfigReader.getProperty("tel"));
        etsTurPage.tcKimlikTextBoxLink.sendKeys(ConfigReader.getProperty("tc"));
        ReusableMethods.bekle(2);

        // Sayfayı en alta indirme
        actions.sendKeys(Keys.END).perform();

        // Ödeme butonuna tıklanması
        etsTurPage.odemeButton.click();
    }

    @Then("Odeme bilgileri sayfasına gidildigini gorur.")
    public void odemeBilgileriSayfasınaGidildiginiGorur() {
        ReusableMethods.bekle(1);

        // Doğru sayfaya gidildiğinin kontrolü
        Assert.assertTrue(etsTurPage.odemeBilgileriTextLink.isDisplayed());
    }

    @Then("Cookies kabul eder.")
    public void cookiesKabulEder() {
        ReusableMethods.bekle(2);

        // Cookie kabul etme
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("efilli.rejectAll();");
    }

    @And("Odeme yöntemini secin kisminda kredi kartı seçer ve bu bolumdeki kisimlar yanlis doldurulur ve odemeyi tamamla butonuna basar.")
    public void odemeYönteminiSecinKismindaKrediKartıSeçerVeBuBolumdekiKisimlarYanlisDoldurulurVeOdemeyiTamamlaButonunaBasar() {
        ReusableMethods.bekle(2);

        // Banka kartı sekmesini seçme
        etsTurPage.bankaKartLink.click();
        ReusableMethods.bekle(1);

        // Kart bilgileri giriş
        etsTurPage.kartIsimTextBoxLink.sendKeys(ConfigReader.getProperty("kartisim"));
        etsTurPage.kartNoTextBoxLink.sendKeys(ConfigReader.getProperty("kartno"));
        etsTurPage.sonKullanimTextBoxLink.sendKeys(ConfigReader.getProperty("sonkullanim"));
        etsTurPage.cvvTextBoxLink.sendKeys(ConfigReader.getProperty("cvv"));
        ReusableMethods.bekle(1);

        // Checkbox işaretleme
        etsTurPage.serviceCheckBoxLink.click();
        etsTurPage.kvkkCheckBoxLink.click();
        ReusableMethods.bekle(1);

        // Odeme tamamla butonuna tıklama
        etsTurPage.odemeTamamlaButton.click();
    }

    @Then("Rezervasyonun onaylanmadigini gorur.")
    public void rezervasyonunOnaylanmadiginiGorur() {
        ReusableMethods.bekle(2);

        // Başarısız rezervasyon doğrulama
        Assert.assertTrue(etsTurPage.basarisizRezervText.isDisplayed());
        ReusableMethods.bekle(2);
    }
}
