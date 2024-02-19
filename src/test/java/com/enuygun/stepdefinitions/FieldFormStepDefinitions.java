package com.enuygun.stepdefinitions;

import com.enuygun.core.configurations.DriverFactory;
import com.enuygun.pageobjects.pages.FieldFormPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FieldFormStepDefinitions {

    private final FieldFormPage fieldFormPage;

    public FieldFormStepDefinitions(DriverFactory driverFactory) {
        WebDriver driver = driverFactory.createInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        fieldFormPage = new FieldFormPage(driver);
    }

    @Then("Bilgileri tamamla sayfa kontrolü")
    public void bilgileriTamamlaSayfaKontrol() {
        fieldFormPage.bilgileriTamamlaSayfaKontrol();
    }

}
