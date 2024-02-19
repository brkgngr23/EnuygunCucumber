package com.enuygun.pageobjects.pages;

import com.enuygun.pageobjects.locators.SelectTicketLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import com.enuygun.core.utils.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class SelectTicketPage extends BasePage {

    public SelectTicketPage(WebDriver driver) {
        super(driver);
    }

    public void biletSecimSayfasiKontrolu() {
        browser.waitElement(SelectTicketLocators.fieldAramayiFavorilereEkle);
    }

    public void selectSaatFiltresi() throws InterruptedException {
        browser.click(SelectTicketLocators.selectTarihFilter);

        WebElement sliderTarihLeft = driver.findElement(By.xpath(SelectTicketLocators.sliderTarihLeft));
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(sliderTarihLeft)
                .moveByOffset(100, 0) // x koordinatında 50 birim sağa sürükleyin
                .release()
                .build();
        dragAndDrop.perform();

        browser.waitElement(By.xpath(SelectTicketLocators.sliderTarihRight));
        Thread.sleep(1000);

        WebElement sliderTarihRight = driver.findElement(By.xpath(SelectTicketLocators.sliderTarihRight));
        Action dragAndDrop2 = builder.clickAndHold(sliderTarihRight)
                .moveByOffset(-60, 0) // x koordinatında 50 birim sağa sürükleyin
                .release()
                .build();
        dragAndDrop2.perform();
        Thread.sleep(1000);

    }

    public void controlBiletTarih() throws ParseException {
        List<WebElement> elements = driver.findElements(By.cssSelector(SelectTicketLocators.textKalkisTarih));
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        for (WebElement element : elements) {
            String text = element.getText();
            Date date = format.parse(text);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            if (hour >= 10 && hour <= 18) {
                log.info("Saat kontrolü başarılı");
            } else {
                throw new RuntimeException("Saat Kontrolü başarısız");
            }
        }
    }

    public void controlFiyat() {
        List<WebElement> elements = driver.findElements(By.cssSelector(SelectTicketLocators.textFiyat));
        List<Integer> numbers = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText();
            text = text.replace(".", "");
            int number = Integer.parseInt(text);
            numbers.add(number);
        }

        Integer[] array = numbers.toArray(new Integer[0]);

        boolean isSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            log.info("Fiyat sıralaması doğru.");
        } else {
            throw new RuntimeException("Fiyat sıralaması hatalı");
        }
    }

    public void biletSec() {
        List<WebElement> elements = driver.findElements(By.xpath(SelectTicketLocators.buttonSec));
        elements.get(0).click();
        browser.click(SelectTicketLocators.buttonSecVeIlerle);
        browser.click(SelectTicketLocators.buttonSecDonus);
        browser.click(SelectTicketLocators.buttonSuperEco);
    }

}