package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SinglePhonePage {

    @FindBy(css = "h1.t-product-name>span")
    public WebElement phoneH2Title;

    public SinglePhonePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
