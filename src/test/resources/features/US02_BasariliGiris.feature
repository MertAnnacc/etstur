
Feature: US_02 Kullanıcı siteye giriş yapabilmeli.

  Scenario: TC_0201 Bir kullanıcı olarak siteye giriş yapılabilmelidir.

    Given Kullanıcı etstur.com adresine gider.
    Then  Cookies kabul eder.
    Then  Giris yap dropdown menusunu gorur.
    Then  Giris yap linkine tıklar.
    And   E-mail ve şifre textbox gorur.
    Then  E-mail ve sifre girer.
    Then  Basarılı bir sekilde giris yapabildigini gorur.
    And   Sayfayı kapatır.