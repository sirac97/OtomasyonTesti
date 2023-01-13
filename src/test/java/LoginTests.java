import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.IntToDoubleFunction;

public class LoginTests {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void acikPozisyonlar() throws InterruptedException{

        driver.get("https://kariyer.baykartech.com/tr/");  // Baykar Kariyer adresine git.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fix-btn"))); // Sağ altta bulunan Açık Pozisyonlar butonuna tıkla
        driver.findElement(By.cssSelector(".fix-btn")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"27\"]"))); // Ağ, Bilişim ve Bilgi Güvenliği Sistemleri checkbox'ını seçme
        driver.findElement(By.xpath("//*[@id=\"27\"]"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"myUL\"]/li[1]/div/div[3]/button"))); // Açılan pozisyonun yanındaki Başvur butonuna tıklama
        driver.findElement(By.xpath("//*[@id=\"myUL\"]/li[1]/div/div[3]/button"));


    }


    @Test
    void baykarLoginTesti() throws InterruptedException{

        driver.get("https://kariyer.baykartech.com/tr/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"home\"]/nav/div/div[1]/ul/li[2]/a"))); // Sağ üstteki Giriş yap butonu
        driver.findElement(By.xpath("//*[@id=\"home\"]/nav/div/div[1]/ul/li[2]/a")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login"))); // E-mail textbox alanına yazı yazma
        driver.findElement(By.name("login")).sendKeys("sracboran@gmail.com");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_password"))); // Şifre textbox alanına yazı yazma
        driver.findElement(By.id("id_password")).sendKeys("12345");


    }

    @Test
    void baykarKayıtOlTesti() throws InterruptedException{

        driver.get("https://kariyer.baykartech.com/tr/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"home\"]/nav/div/div[1]/ul/li[2]/a")));
        driver.findElement(By.xpath("//*[@id=\"home\"]/nav/div/div[1]/ul/li[2]/a")).click(); // Sağ üstteki Giriş yap butonu

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loginForm\"]/div[1]/div/a")));
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div/a")).click(); // Hesap oluştur yazısına tıklama

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_email")));
        driver.findElement(By.id("id_email")).sendKeys("sracboran@gmail.com"); // E-mail textbox alanına yazı yazma

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_password1")));
        driver.findElement(By.id("id_password1")).sendKeys("12345"); // Şifre textbox alanına yazı yazma

        driver.findElement(By.id("id_password1")).sendKeys("12345"); // Şifre textbox alanına tekrar yazı yazma
    }

    @Test
    void meslekDetayıveBasvuru() throws InterruptedException {

        driver.get("https://kariyer.baykartech.com/tr/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='item active']//a[contains(.,'Detay')]")));
        driver.findElement(By.xpath("//div[@class='item active']//a[contains(.,'Detay')]")).click(); // Anasayfa görselinde yer alan Detay butonuna bas

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btnBaykar")));
        driver.findElement(By.cssSelector(".btnBaykar")).click(); // Açılan detay sayfasında altta yer alan Başvur butonuna bas
    }


    @AfterEach
    void closeBrowser(){
        driver.close();
    }

}
