
Feature: US_03 Rezervasyon aşamalarının son kısmına kadar gelmeliyim.

  Scenario: TC_0301 Bir kullanıcı olarak rezervasyon işlemlerinin son aşamasına kadar gelebilmeliyim.

    Given Kullanıcı etstur.com adresine gider.
    Then  Cookies kabul eder.
    Then  Giris yap linkine tıklar.
    Then  E-mail ve sifre girer.
    Then  Basarılı bir sekilde giris yapabildigini gorur.
    And   Anasayfa bulunan,Nereye gitmek istersin?,Gidis tarihi,Donüs tarihi,kişi sayısı alanlarını gorur.
    Then  Bu alanlarda seçmlerini yapar ve ara butonuna basar.
    Then  İlgili sayfaya gittiğini gorur.
    And   İstedigi oteli seçer ve açılan sayfada istedigi odayı seçip odayı seç linkine tıklar.
    Then  Misafir bilgileri ekranını gorur.
    Then  Bu bölümdeki kısımları doldurulur ve ödeme adımına ilerle butonuna basar.
    Then  Odeme bilgileri sayfasına gidildigini gorur.
    And   Odeme yöntemini secin kisminda kredi kartı seçer ve bu bolumdeki kisimlar yanlis doldurulur ve odemeyi tamamla butonuna basar.
    Then  Rezervasyonun onaylanmadigini gorur.
    And   Sayfayı kapatır.