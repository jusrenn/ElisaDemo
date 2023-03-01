package stepDefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;
import pages.PuhelimetJaTarvikkeetPage;
import pages.PuhelimetPage;
import pages.SinglePhonePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class ElisaStepDefinition {

    private static final Logger logger = (Logger) LogManager.getLogger();

    HomePage homePage = new HomePage();
    PuhelimetJaTarvikkeetPage puhelimetJaTarvikkeetPage = new PuhelimetJaTarvikkeetPage();
    PuhelimetPage puhelimetPage = new PuhelimetPage();
    SinglePhonePage singlePhonePage = new SinglePhonePage();

    @Given("Menee elisa.fi nettisivulle.")
    public void menee_elisa_fi_nettisivulle() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Menty elisa.fi nettisivulle!");
        ReusableMethods.waitForClickablity(homePage.cookiesButton, 5);
        homePage.cookiesButton.click();
        logger.info("Cookies hyväksytty!");
    }
    @Given("Menee puhelimet sivulle.")
    public void menee_puhelimet_sivulle() {
        homePage.tuotteetJaPalvelutLink.click();
        logger.info("Tuotteet ja palvelut linkki klikattu!");
        homePage.laitteetLink.click();
        logger.info("Laitteet linkki klikattu!");
        homePage.puhelimetJaTarvikkeetLink.click();
        logger.info("Puhelimet ja tarvikkeet linkki klikattu!");
        puhelimetJaTarvikkeetPage.puhelimet.click();
        logger.info("Puhelimet linkki klikattu!");
    }
    @Given("Järjestele tuotteita")
    public void jarjestele_tuotteita() {
        puhelimetPage.lisaaRajausDropDownMenu.click();
        logger.info("Lisää rajaus dropdown menu klikattu!");
        puhelimetPage.appleLabel.click();
        logger.info("Apple valitettu!");
        puhelimetPage.priceLabel.click();
        logger.info("Hinta valitettu!");
        puhelimetPage.lisaaRajausDropDownMenu.click();
        logger.info("Lisää rajaus dropdown menu klikattu!");
        puhelimetPage.sortDropDownMenu.click();
        logger.info("Tuote järjestys menu klikattu!");
        puhelimetPage.sortPrice.click();
        logger.info("Halvin valitettu!");
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollTo(0,250)");
        logger.info("Menty sivun alaspain!");
    }
    @Given("Klikkaa ensimmäistä tuotetta.")
    public void klikkaa_ensimmaista_tuotetta() {
        puhelimetPage.phoneList.click();
        logger.info("Ensimmäistä tuote klikattu!");
    }
    @Given("Vahvista että onko {string} valittu.")
    public void vahvista_että_onko_valittu(String string) {
        Assert.assertTrue(singlePhonePage.phoneH2Title.getText().equals(string));
        logger.info("Odetetut tulos ja todelliset tulos on sama!");
    }
    @Given("Sulje browser.")
    public void sulje_browser() {
        Driver.close();
        logger.info("Browser suljettu!");
    }
}
