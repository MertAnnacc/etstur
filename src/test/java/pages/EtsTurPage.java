package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;



public class EtsTurPage {

    public EtsTurPage(){
            PageFactory.initElements(Driver.getDriver(),this);}
    //US_01-TC01
    @FindBy(xpath = "//div[@class='dropdown user-dropdown']")
        public WebElement girisDropdownMenu;

    @FindBy(xpath = "//button[@type='button']//span[contains(text(),'Giriş Yap')]")
        public WebElement girisLink;

    // US_02-TC01
    @FindBy(xpath = "//input[@id='tb-contactEmailSignIn']")
        public WebElement emailTextBoxLink;

    @FindBy(xpath = "//input[@id='showPass_2']")
        public WebElement passwordTextBoxLink;

    @FindBy(xpath = "//button[@id='btn-signin']")
        public WebElement girisButton;

    @FindBy(xpath = "//button[@class='mfp-close wis-mfp-close-228133']")
        public WebElement girisCloseButton;

    @FindBy(xpath = "//b[@class='username']")
        public WebElement userProfileLink;

    @FindBy(xpath = "//a[text()=' Hesabım ']")
        public WebElement hesabımLink;

    // US_03-TC01

    @FindBy(xpath = "//input[@id='tb-autocomplete']")
        public WebElement neresiBox;

    @FindBy(xpath = "//span[normalize-space()='Erken Rezervasyon Otelleri']")
        public WebElement rezervasyonOtelLink;

    @FindBy(xpath = "//span[text()='Giriş Tarihi']")
        public WebElement gidisLink;

    @FindBy(xpath = "//span[contains(text(),'2 Yetişkin')]")
        public WebElement kisiSayiLink;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[5]/td[1]")
        public WebElement gidisTarihLink;

    @FindBy(xpath = "//span[text()='Çıkış Tarihi']")
        public WebElement donusLink;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[7]/td[2]")
        public WebElement donusTarihLink;

    @FindBy(xpath = "//button[text()='ARA']")
        public WebElement araButton;

    @FindBy(xpath = "//h2[normalize-space()='Baia Lara']")
        public WebElement hotelNameLink;

    @FindBy(xpath = "(//a[@title='Odayı Seç'])[1]")
        public WebElement odaSecLink;

    @FindBy(xpath = "//h4[text()='Misafir Bilgileri']")
        public WebElement misafirLink;

    @FindBy(xpath = "//input[@id=':r1:']")
        public WebElement isimTextBoxLink;

    @FindBy(xpath = "//input[@id=':r2:']")
        public WebElement soyIsimTextBoxLink;

    @FindBy(xpath = "//input[@id=':r3:']")
        public WebElement epostaTextBoxLink;

    @FindBy(xpath = "//input[@id=':r4:']")
        public WebElement telefonTextBoxLink;

    @FindBy(xpath = "//input[@id=':r5:']")
        public WebElement tcKimlikTextBoxLink;

    @FindBy(xpath = "//button[contains(text(),'Ödeme Adımına İlerle')]")
        public WebElement odemeButton;

    @FindBy(xpath = "//h4[text()='Ödeme Bilgileri']")
        public WebElement odemeBilgileriTextLink;

    @FindBy(xpath = "//div[@class='MuiAccordionSummary-content css-1n11r91']")
        public WebElement bankaKartLink;

    @FindBy(xpath = "//input[@id=':r8:']")
        public WebElement kartIsimTextBoxLink;

    @FindBy(xpath = "//input[@id=':r9:']")
        public WebElement kartNoTextBoxLink;

    @FindBy(xpath = "//input[@id=':ra:']")
        public WebElement sonKullanimTextBoxLink;

    @FindBy(xpath = "//input[@id=':rb:']")
        public WebElement cvvTextBoxLink;

    @FindBy(xpath = "//div[@class='css-m5vuyl']//input[@name='serviceAgreement']")
        public WebElement serviceCheckBoxLink;

    @FindBy(xpath = "//div[@class='css-m5vuyl']//input[@name='kvkk']")
        public WebElement kvkkCheckBoxLink;

    @FindBy(xpath = "//button[normalize-space()='Ödemeyi tamamla']")
        public WebElement odemeTamamlaButton;

    @FindBy(xpath = "//h2[text()='Rezervasyonunuz gerçekleşmedi!']")
        public WebElement basarisizRezervText;






}
