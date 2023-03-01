package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

// page_url = https://elisa.fi/kauppa/laitteet/puhelimet_ja_tarvikkeet/puhelimet
public class PuhelimetPage {

    @FindBy(css = "div.ea-combobox--without-overlay")
    public WebElement lisaaRajausDropDownMenu;

    @FindBy(xpath = "(//div[@class='ea-combobox ea-combobox--dropdown'])[1]")
    public WebElement sortDropDownMenu;

    @FindBy(css = "[data-value=lowest]")
    public WebElement sortPrice;

    @FindBy(xpath = "//label/div[contains(text(),'Apple')]")
    public WebElement appleLabel;

    @FindBy(xpath = "//label/div[contains(text(),'800 - 1200')]")
    public WebElement priceLabel;

    @FindBy(xpath = "(//h2[@class='ea-marketing-product__product-name ea-bodytext'])[1]")
    public WebElement phoneList;

    public PuhelimetPage() {
        if(ConfigReader.getProperty("showBrowser").equals("true")) {
            PageFactory.initElements(Driver.getDriver(), this);
        } else {
            PageFactory.initElements(Driver.getDriverNoBrowser(), this);
        }
    }
}
