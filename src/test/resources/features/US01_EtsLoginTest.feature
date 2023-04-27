
Feature: US_01 Kullanıcı anasayfaya erişebilmeli.

  Scenario: TC_0101 kullanıcı anasayfaya gider.

    Given Kullanıcı etstur.com adresine gider.
    Then  Cookies kabul eder.
    Then  Sitenin title  gorur ve dogru sitede oldugunu anlar.
    And   Sayfayı kapatır.