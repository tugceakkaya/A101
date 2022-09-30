package ApplicationPages;

import junit.framework.Assert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import WebConnector.webconnector;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import schemasMicrosoftComOfficeExcel.STObjectType;

import static WebConnector.webconnector.driver;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Homepage {
    webconnector wc = new webconnector();

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void goToHomePage() throws InvalidFormatException, IOException {
        String URL = wc.getSpecificColumnData("./src/test/testdata/data.xlsx", "sheet1", "URL");
        driver.get(URL);
        wc.waitForCondition("PageLoad", "", 60);
        WebElement cerez = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        cerez.click();
    }

    public void giyimAksesuar() {

        WebElement clickable = driver.findElement(By.xpath(" //ul[@class='desktop-menu']/li[4]"));
        new Actions(driver).clickAndHold(clickable).perform();
    }

    public void dizAltıÇorap() {

        try {
            wc.PerformActionOnElement("dizalti", "Click", "");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void randomUrunSec() {
        List<WebElement> dizAltiÇorapListesi = driver.findElements(By.xpath("//h3[@class='name']"));
        Random r = new Random();
        int randomValue = r.nextInt(dizAltiÇorapListesi.size()); //Getting a random value that is between 0 and (list's size)-1
        dizAltiÇorapListesi.get(randomValue).click();
    }

    public void siyahMı() {


        String actualString = driver.findElement(By.xpath("//h1[@class='product-name js-name']")).getText();


        if (actualString.contains("Siyah")) {
            System.out.println("Siyah çorap seçildi");


        } else {
            System.out.println("Siyah çorap seçilemedi");

            String dizaltiCorapUrl = "https://www.a101.com.tr/giyim-aksesuar/dizalti-corap/";
            driver.get(dizaltiCorapUrl);
            randomUrunSec();
            System.out.println("Tekrardan ürün seçildi");
            siyahMı();

        }
    }

    public void sepeteEkle() throws Exception {

        List<WebElement> dynamicElement = driver.findElements((By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']")));
        if (dynamicElement.size() != 0) {
            //If list size is non-zero, element is present
            driver.findElement(By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']")).click();
            System.out.println("Sepete eklendi");
        } else {
            //Else if size is 0, then element is not present
            System.out.println("Seçilen Ürün tükendi Lütfen başka ürün seçin");

            String dizaltiCorapUrl = "https://www.a101.com.tr/giyim-aksesuar/dizalti-corap/";
            driver.get(dizaltiCorapUrl);
            randomUrunSec();
            System.out.println("Tekrardan ürün seçildi");
            siyahMı();
            sepeteEkle();

        }

    }

    public void sepetiGoruntule() throws Exception {


        WebElement sepetGoruntule = driver.findElement(By.className("go-to-shop"));
        sepetGoruntule.click();
        System.out.println("Sepet görüntüleye tıklanıd");
    }

    public void sepetiOnayla() throws Exception {
        WebElement sepetOnayla = driver.findElement(By.xpath("//a[@href='/orders/checkout/']"));
        sepetOnayla.click();

        System.out.println("Sepet onaylandı");
    }

    public void uyeOlmadanDevamEt() throws Exception {
      WebElement uyeOlmadanDevamEt = driver.findElement(By.cssSelector("a[title='ÜYE OLMADAN DEVAM ET']"));
      //js.executeScript("arguments[0].scrollIntoView();",uyeOlmadanDevamEt);
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",uyeOlmadanDevamEt);
       uyeOlmadanDevamEt.click();

      //  driver.findElement(By.linkText("ÜYE OLMADAN DEVAM ET")).click();

        System.out.println("uye olmadan devam edildi");
    }

    public void eMailGir() throws Exception {

        wc.PerformActionOnElement("email","Type","tugcetunc1@gmail.com");
        System.out.println("Email bilgisi girildi");

    }

    public void devamEt() throws Exception {
        wc.PerformActionOnElement("devamEt","Click","");
        System.out.println("Devam et butonuna tıklandı");
    }

    public void yenıAdresOluştur() throws Exception {
        wc.PerformActionOnElement("adres_olustur","Click","");
        System.out.println("Adres olustura tıklandı");
    }

    public  void adresGuncelleme() throws Exception {
       wc.PerformActionOnElement("adresBasligi","Type","İş adresim");

        System.out.println("Adres başlığı girildi");
        wc.PerformActionOnElement("isim","Type","Tuğçe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("İsim girildi");

        wc.PerformActionOnElement("soyad","Type","Akkaya");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Soyisim girildi");
        wc.PerformActionOnElement("cepTelefonu","Type","05458631258");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Cep telefonu girildi");

      WebElement sehir= driver.findElement(By.xpath("//select[@name='city']"));

        Select select = new Select(sehir);

        select.selectByIndex(3);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Şehir bilgisi seçildi");

        WebElement ilce= driver.findElement(By.xpath("//select[@name='township']"));
        Select select2 = new Select(ilce);

        select2.selectByIndex(8);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         System.out.println("İlce bilgisi seçildi");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement mahalle= driver.findElement(By.xpath("//select[@name='district']"));
        Select select3 = new Select(mahalle);


        select3.selectByIndex(2);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Mahalle bilgisi seçildi");

       wc.PerformActionOnElement("acikAdres","Type","Adatepe 2/3 sokak no :37");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Açık adres bilgisi girildi");

        wc.PerformActionOnElement("kaydet", "Click", "");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Kaydet e tıklandı");

        wc.PerformActionOnElement("kaydetVeDevam","Click","");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wc.PerformActionOnElement("siparisiTamamla", "Click","");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String actualResult=driver.findElement(By.xpath("//div[@class='installment-area']/span")).getText();
        System.out.println(actualResult);
        String expectedResult="Lütfen kart seçin veya kart bilgisi girin.";
        Assert.assertEquals(expectedResult,actualResult);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


}



