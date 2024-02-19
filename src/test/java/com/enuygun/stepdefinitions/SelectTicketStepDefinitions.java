package com.enuygun.stepdefinitions;


import com.enuygun.core.configurations.DriverFactory;
import com.enuygun.pageobjects.pages.SelectTicketPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class SelectTicketStepDefinitions {

    private final SelectTicketPage selectTicketPage;


    public SelectTicketStepDefinitions(DriverFactory driverFactory) {
        WebDriver driver = driverFactory.createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        selectTicketPage = new SelectTicketPage(driver);

    }

    @Then("Bilet Seçim Ekranı Kontrolü")
    public void biletSecimSayfasiKontrolu() {
        selectTicketPage.biletSecimSayfasiKontrolu();
    }
    @When("Bilet Saat aralığı filtresi uygulanır")
    public void biletSaatFiltre() throws InterruptedException {
        selectTicketPage.selectSaatFiltresi();
    }
    @Then("Saat aralığı kontrol edilir")
    public void controlBiletTarih() throws ParseException {
        selectTicketPage.controlBiletTarih();
    }
    @Then("Fiyat sıralaması kontrol edilir")
    public void controlFiyat() {
        selectTicketPage.controlFiyat();
    }
    @When("Gidiş dönüş bilet seçilir")
    public void biletSec() {
        selectTicketPage.biletSec();
    }




}

