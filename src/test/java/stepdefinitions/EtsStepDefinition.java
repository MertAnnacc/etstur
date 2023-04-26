package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import pages.EtsTurPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class EtsStepDefinition {

    EtsTurPage etsTurPage = new EtsTurPage();


    @Given("Kullanıcı etstur.com adresine gider.")
    public void kullanıcı_etstur_com_adresine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("Url"));

    }


    @Then("Sitenin title  gorur ve dogru sitede oldugunu anlar.")
    public void siteninTitleGorurVeDogruSitedeOldugunuAnlar() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Tatil";

        ReusableMethods.bekle(3);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @And("Sayfayı kapatır.")
    public void sayfayıKapatır() {
        Driver.getDriver().quit();
    }

    @Then("Giris yap dropdown menusunu gorur.")
    public void girisYapDropdownMenusunuGorur() {
        ReusableMethods.bekle(2);

        Assert.assertTrue(etsTurPage.girisDropdownMenu.isDisplayed());
    }

    @Then("Giris yap linkine tıklar.")
    public void girisYapLinkineTıklar() {
        etsTurPage.girisDropdownMenu.click();
        etsTurPage.girisLink.click();
        ReusableMethods.bekle(2);
    }

    @And("E-mail ve şifre textbox gorur.")
    public void eMailVeŞifreTextboxGorur() {
        Assert.assertTrue(etsTurPage.emailTextBoxLink.isDisplayed());
        Assert.assertTrue(etsTurPage.passwordTextBoxLink.isDisplayed());
        ReusableMethods.bekle(2);
    }

    @Then("E-mail ve sifre girer.")
    public void eMailVeSifreGirer() {
        ReusableMethods.bekle(2);
        etsTurPage.emailTextBoxLink.sendKeys(ConfigReader.getProperty("UserName"));
        ReusableMethods.bekle(1);

        etsTurPage.passwordTextBoxLink.sendKeys(ConfigReader.getProperty("Password"));
    }

    @Then("Basarılı bir sekilde giris yapabildigini gorur.")
    public void basarılıBirSekildeGirisYapabildiginiGorur() {
       etsTurPage.girisButton.click();
       ReusableMethods.bekle(2);

       etsTurPage.girisCloseButton.click();

       etsTurPage.userProfileLink.click();
       Assert.assertTrue(etsTurPage.hesabımLink.isDisplayed());

    }

    @And("Anasayfa bulunan,Nereye gitmek istersin?,Gidis tarihi,Donüs tarihi,kişi sayısı alanlarını gorur.")
    public void anasayfaBulunanNereyeGitmekIstersinGidisTarihiDonüsTarihiKişiSayısıAlanlarınıGorur() {
        ReusableMethods.bekle(1);
        Assert.assertTrue(etsTurPage.neresiBox.isDisplayed());
        Assert.assertTrue(etsTurPage.gidisLink.isDisplayed());
        Assert.assertTrue(etsTurPage.donusLink.isDisplayed());
        Assert.assertTrue(etsTurPage.kisiSayiLink.isDisplayed());
        ReusableMethods.bekle(1);



    }

    @Then("Bu alanlarda seçmlerini yapar ve ara butonuna basar.")
    public void buAlanlardaSeçmleriniYaparVeAraButonunaBasar() {
        etsTurPage.neresiBox.click();
        ReusableMethods.bekle(1);
        etsTurPage.rezervasyonOtelLink.click();
        ReusableMethods.bekle(1);

        etsTurPage.gidisLink.click();
        ReusableMethods.bekle(1);
        etsTurPage.gidisTarihLink.click();
        ReusableMethods.bekle(1);

        // etsTurPage.donusLink.click();
        ReusableMethods.bekle(1);
        etsTurPage.donusTarihLink.click();
        ReusableMethods.bekle(1);

        etsTurPage.araButton.click();
    }

    @Then("İlgili sayfaya gittiğini gorur.")
    public void ilgiliSayfayaGittiğiniGorur() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Erken";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @And("İstedigi oteli seçer ve açılan sayfada istedigi odayı seçip odayı seç linkine tıklar.")
    public void istedigiOteliSeçerVeAçılanSayfadaIstedigiOdayıSeçipOdayıSeçLinkineTıklar() {
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);
        etsTurPage.hotelNameLink.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(2);

        etsTurPage.odaSecLink.click();


    }
}
