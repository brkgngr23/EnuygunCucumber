package com.enuygun.stepdefinitions;

import com.enuygun.core.configurations.DriverFactory;
import com.enuygun.pageobjects.pages.MainPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class MainPageStepDefinitions {


    private final MainPage mainPage;

    public MainPageStepDefinitions(DriverFactory driverFactory) {
        WebDriver driver = driverFactory.createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);


    }

    @Given("Navigate to dashboard")
    public void navigatePage() {
        mainPage.navigate();
    }
    @When("Gidiş-Dönüş checkbox'ı seçilir")
    public void gidisDonusSec() {
        mainPage.selectCheckboxGidisDonus();
    }
    @And("Nereden: {string}, Nereye: {string} gidileceği seçilir")
    public void selectNeredenNereye(String gidis,String donus) throws InterruptedException {
        mainPage.selectNeredenNereye(gidis,donus);
    }
    @And("{string} tarihi- Gün: {string}, Ay-Yıl: {string} seçilir")
    public void selectTarih(String gidisDonus,String gun,String ayYil) throws InterruptedException {
        mainPage.selectTarih(gidisDonus,gun,ayYil);
    }
    @And("Bilet bul'a tıklanır")
    public void clickSubmit(){
        mainPage.clickBiletBul();
    }

}

