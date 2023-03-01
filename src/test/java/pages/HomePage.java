package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

// page_url = https://www.elisa.fi
public class HomePage {

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookiesButton;

    @FindBy(css = "button.react-navi-ea-mainheader-search-button")
    public WebElement searchButton;

    @FindBy(css = "input.react-navi-ea-mainheader-search-word")
    public WebElement searchBoxInput;

    @FindBy(xpath = "(//a[@id='Tuotteet_ja_palvelut'])[1]")
    public WebElement tuotteetJaPalvelutLink;

    @FindBy(xpath = "(//a[@id='Laitteet'])[1]")
    public WebElement laitteetLink;

    @FindBy(xpath = "(//a[@id='Puhelimet_ja_tarvikkeet'])[1]")
    public WebElement puhelimetJaTarvikkeetLink;

    public HomePage() {
        if(ConfigReader.getProperty("showBrowser").equals("true")) {
            PageFactory.initElements(Driver.getDriver(), this);
        } else {
            PageFactory.initElements(Driver.getDriverNoBrowser(), this);
        }
    }
}