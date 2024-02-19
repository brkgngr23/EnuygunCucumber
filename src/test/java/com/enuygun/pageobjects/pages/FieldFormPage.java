package com.enuygun.pageobjects.pages;

import com.enuygun.pageobjects.locators.FieldFormLocators;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.enuygun.core.utils.log;

public class FieldFormPage extends BasePage {

    public FieldFormPage(WebDriver driver) {
        super(driver);
    }

    public void bilgileriTamamlaSayfaKontrol() {
        browser.waitElement(FieldFormLocators.fieldForm);
        Assert.assertTrue(browser.isElementPresent(FieldFormLocators.fieldForm));
        log.info("Bilgileri tamamla sayfasına giriş başarılı");

    }


}
