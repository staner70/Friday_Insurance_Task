package com.friday.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectPreconditionPage extends PageObject{
    @FindBy(xpath = "//input[@value='buyingCar']")
    public WebElement buyingCarRadioBtn;
}
