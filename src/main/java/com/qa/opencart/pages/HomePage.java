package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private ElementUtils eleutils;

    public HomePage(){
        this.driver = driver;
        eleutils = new ElementUtils(driver);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    private By quickSearchIcon = By.xpath("//img[@src='./images/adlNewImages/search.png']");
    private By quickSearchTextBox = By.id("ClientSearchBoxDashboard_txtClientSearch");

    private String clientName = "Mr testprod testprod";
    private By clientName = By.xpath("//td[@cname = '"+clientName+"']");
    private By addClient = By.xpath("//img[@src='Images/adlNewImages/add_client.png']");

    private By ctitle = By.id("cboTitle");
    private By fname = By.id("txtGivenName");
    private By sname = By.id("txtSurName");
    private By dob = By.id("calDob");
    private By gender = By.id("cboSex");


}
