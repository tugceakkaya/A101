package stepdefs;

import java.io.IOException;

import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import ApplicationPages.Homepage;
import WebConnector.webconnector;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps extends webconnector {
    private Homepage homePage;
	private String scenDesc;

    public HomePageSteps() {
        this.homePage = new Homepage();
    }
    
    @Before
	public void before(Scenario scenario) {
		this.scenDesc = scenario.getName();
		setUpDriver();
	}
    
    @After
    public void after(Scenario scenario){
    	closeDriver(scenario);
    }
	
	@BeforeStep
	public void beforeStep() throws InterruptedException {
		Thread.sleep(2000);
	}

    @Given("^A101 web sayfasına git$")
    public void aUserNavigatesToHomePage() throws InvalidFormatException, IOException {
        this.homePage.goToHomePage();
    }

    @Then("^Giyim ve aksesuar bölümüne tıkla$")
    public void giyimVeAksesuar() throws Exception {
        this.homePage.giyimAksesuar();
    }
    @Then("^Dizaltı çorap bölümüne tıkla$")
    public void dizAltıÇorap() throws Exception {
        this.homePage.dizAltıÇorap();

    }

    @Then("^Random urun sec$")
    public void randomSec() throws Exception {
        this.homePage.randomUrunSec();

    }

    @When("^Seçilen ürün siyah mı kontrol et$")
    public void siyahMı(){
        this.homePage.siyahMı();

    }

    @Then("^Sepete ekle$")
    public void sepeteEkle() throws Exception {
        this.homePage.sepeteEkle();
    }
    @Then("^Sepeti goruntule$")
    public void sepetGoruntule() throws Exception {
        this.homePage.sepetiGoruntule();
    }
    @Then("^Sepeti onayla")
    public void sepetOnayla() throws Exception {
        this.homePage.sepetiOnayla();
    }
    @Then("^Uye Olmadan devam et")
    public void uyeOlmadanDevamEt() throws Exception {
        this.homePage.uyeOlmadanDevamEt();
    }
    @Then("Email gir")
    public void emailGir() throws Exception {
        this.homePage.eMailGir();
    }

    @Then("Devam Et'e tıkla")
    public void devamEt() throws Exception {
        this.homePage.devamEt();
    }

    @Then("Yeni adres olustur")
    public void adresOlustur() throws Exception {
        this.homePage.yenıAdresOluştur();
    }

    @Then("Adres bilgileri girilir")
    public void adresBilgileri() throws Exception {
        this.homePage.adresGuncelleme();
    }



}
