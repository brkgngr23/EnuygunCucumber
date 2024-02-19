@paralel
Feature: EnuygunCase

  @tag-1
  Scenario: Enuygun- Case 1
    Given Navigate to dashboard
    Then Gidiş-Dönüş checkbox'ı seçilir
    And Nereden: "İstanbul Sabiha Gökçen", Nereye: "Ankara Esenboğa Havalimanı" gidileceği seçilir
    And "Gidiş" tarihi- Gün: "15", Ay-Yıl: "Mart 2024" seçilir
    And "Dönüş" tarihi- Gün: "16", Ay-Yıl: "Mart 2024" seçilir
    And Bilet bul'a tıklanır
    Then Bilet Seçim Ekranı Kontrolü
    When Bilet Saat aralığı filtresi uygulanır
    Then Saat aralığı kontrol edilir

  @tag-2
  Scenario: Enuygun- Case 2
    Given Navigate to dashboard
    Then Gidiş-Dönüş checkbox'ı seçilir
    And Nereden: "İstanbul Sabiha Gökçen", Nereye: "Ankara Esenboğa Havalimanı" gidileceği seçilir
    And "Gidiş" tarihi- Gün: "15", Ay-Yıl: "Mart 2024" seçilir
    And "Dönüş" tarihi- Gün: "16", Ay-Yıl: "Mart 2024" seçilir
    And Bilet bul'a tıklanır
    Then Bilet Seçim Ekranı Kontrolü
    When Bilet Saat aralığı filtresi uygulanır
    Then Fiyat sıralaması kontrol edilir

  @tag-3
  Scenario: Enuygun- Case 3
    Given Navigate to dashboard
    Then Gidiş-Dönüş checkbox'ı seçilir
    And Nereden: "İstanbul Sabiha Gökçen", Nereye: "Ankara Esenboğa Havalimanı" gidileceği seçilir
    And "Gidiş" tarihi- Gün: "15", Ay-Yıl: "Mart 2024" seçilir
    And "Dönüş" tarihi- Gün: "16", Ay-Yıl: "Mart 2024" seçilir
    And Bilet bul'a tıklanır
    Then Bilet Seçim Ekranı Kontrolü
    When Gidiş dönüş bilet seçilir
    Then Bilgileri tamamla sayfa kontrolü








