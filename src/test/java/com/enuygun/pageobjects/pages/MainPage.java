package com.enuygun.pageobjects.pages;

import com.enuygun.core.utils.PropertyUtils;
import com.enuygun.pageobjects.locators.MainPageLocators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.enuygun.core.utils.log;


import java.util.Properties;

public class MainPage extends BasePage {

    private final Properties props = PropertyUtils.getInstance().loadPropertiesFile("auth.properties");
    private final String url = props.getProperty("url");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage navigate() {
        driver.navigate().to(url);
        browser.isElementExist(MainPageLocators.mainPageTitle);
        log.info("Anasayfa basarili sekilde acildi");
        return this;
    }

    public void selectNeredenNereye(String gidis,String donus) throws InterruptedException {
        browser.clickElement(MainPageLocators.fieldNereden);
        browser.sendKeys(MainPageLocators.fieldNeredenTextArea,gidis);
        browser.clickElement(MainPageLocators.firstFieldOnNeredenSearch);
        Assert.assertTrue(gidis.contains(browser.getText(MainPageLocators.fieldNeredenTextArea)));
        log.info("gidis"+ gidis+ "seçildi");
        browser.clickElement(MainPageLocators.fieldNereye);
        browser.sendKeys(MainPageLocators.fieldNereyeTextArea,donus);
        browser.clickElement(MainPageLocators.firstFieldOnNereyeSearch);
        Assert.assertTrue(donus.contains(browser.getText(MainPageLocators.fieldNereyeTextArea)));
        log.info("dönüş"+ donus+ "seçildi");

    }

    public void selectCheckboxGidisDonus() {
        browser.click(MainPageLocators.checkboxGidisDonus);
        log.info("Gidiş Dönüş checkbox'ı seçildi");
    }


    public void selectTarih(String gidisDonusSec,String gun,String ayYil) throws InterruptedException {
        int control=0;
        if (gidisDonusSec.equals("Gidiş")){
            browser.clickElement(MainPageLocators.fieldDateGidis);
        } else if (gidisDonusSec.equals("Dönüş")) {
            browser.clickElement(MainPageLocators.fieldDateDonus);
        }

        String changedDate = (MainPageLocators.changedDate).replace("xxx",ayYil);
        By newChangedDate = By.xpath(changedDate);

        String changedDay = (MainPageLocators.changedDay).replace("xxx",gun);
        By newChangedDay = By.cssSelector(changedDay);

        while (control<1){
            if (browser.isElementPresent(newChangedDate)){
                control++;
            }
            else{
                browser.clickElement(MainPageLocators.buttonMonthForward);
            }
        }
        if (gidisDonusSec.equals("Gidiş")){
            if (browser.findElements(MainPageLocators.fieldMonthYear).get(0).getText().equals(ayYil)){
                browser.findElements(newChangedDay).get(0).click();}
            else if (browser.findElements(MainPageLocators.fieldMonthYear).get(1).getText().equals(ayYil)) {
                browser.findElements(newChangedDay).get(1).click();}
            else {
                log.info("Tarih seçerken bir hata oluştu");
            }
        }

        else if (gidisDonusSec.equals("Dönüş")){
            if (browser.findElements(MainPageLocators.fieldMonthYearDonus).get(0).getText().equals(ayYil)){
                browser.findElements(newChangedDay).get(0).click();}
            else if (browser.findElements(MainPageLocators.fieldMonthYearDonus).get(1).getText().equals(ayYil)) {
                browser.findElements(newChangedDay).get(1).click();}
            else {
                log.info("Tarih seçerken bir hata oluştu");
            }
        }
        else {
            log.info("Tarih seçerken bir hata oluştu");
        }
    }

    public void clickBiletBul() {
        browser.click(MainPageLocators.buttonSubmit);
    }

}
