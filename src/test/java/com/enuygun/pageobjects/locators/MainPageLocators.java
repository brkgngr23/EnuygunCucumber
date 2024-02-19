package com.enuygun.pageobjects.locators;

import org.openqa.selenium.By;

public class MainPageLocators {

    public static final By mainPageTitle = By.xpath("//h1[contains(text(),'Türkiye’nin Seyahat Sitesi')]");
    public static final By fieldNereden = By.xpath("//div[contains(text(),'Nereden')]");
    public static final By fieldNereye = By.xpath("//div[contains(text(),'Nereye')]");
    public static final By fieldNeredenTextArea = By.cssSelector("[data-testid='endesign-flight-origin-autosuggestion-input']");
    public static final By fieldNereyeTextArea = By.cssSelector("[data-testid='endesign-flight-destination-autosuggestion-input']");
    public static final By checkboxGidisDonus = By.cssSelector("[data-testid='search-round-trip-text']");
    public static final By firstFieldOnNeredenSearch = By.cssSelector("[data-testid='endesign-flight-origin-autosuggestion-option-item-0']");
    public static final By firstFieldOnNereyeSearch = By.cssSelector("[data-testid='endesign-flight-destination-autosuggestion-option-item-0']");
    public static final By fieldDateGidis = By.cssSelector("[data-testid='enuygun-homepage-flight-departureDate-datepicker-popover-button']");
    public static final By fieldDateDonus = By.cssSelector("[data-testid='enuygun-homepage-flight-returnDate-datepicker-popover-button']");
    public static final String changedDate = ("//h3[contains(text(),'xxx')]");
    public static final By buttonMonthForward = By.xpath("//button[@data-testid='enuygun-homepage-flight-departureDate-month-forward-button']");
    public static final String changedDay = ("[data-day='xxx']");
    public static final By fieldMonthYear = By.cssSelector("[data-testid='enuygun-homepage-flight-departureDate-month-name-and-year']");
    public static final By fieldMonthYearDonus = By.cssSelector("[data-testid='enuygun-homepage-flight-returnDate-month-name-and-year']");
    public static final By buttonSubmit = By.xpath("//button[@type='submit']");






}
