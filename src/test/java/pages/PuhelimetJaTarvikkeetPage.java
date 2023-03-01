package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

// page_url = https://elisa.fi/kauppa/laitteet/puhelimet_ja_tarvikkeet
public class PuhelimetJaTarvikkeetPage {

    @FindBy(id = "category-page-icon---puhelimet-ja-tarvikkeet---sub-category---puhelimet-1-puhelimet")
    public WebElement puhelimet;

    public PuhelimetJaTarvikkeetPage() {
        if(ConfigReader.getProperty("showBrowser").equals("true")) {
            PageFactory.initElements(Driver.getDriver(), this);
        } else {
            PageFactory.initElements(Driver.getDriverNoBrowser(), this);
        }
    }
}
