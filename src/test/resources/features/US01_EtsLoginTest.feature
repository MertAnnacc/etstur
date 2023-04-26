
Feature: US_01 Kullanıcı anasayfaya erişebilmeli.
@ets
  Scenario: TC_0101 kullanıcı anasayfaya gider.

    Given Kullanıcı etstur.com adresine gider.
    Then Sitenin title  gorur ve dogru sitede oldugunu anlar.
    And Sayfayı kapatır.