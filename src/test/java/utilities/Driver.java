package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver(){ // Default constructor'i devre disi birakmak icin bos costructor olusturuyoruz yani SingletonPattern yapiyoruz.

    }
    static WebDriver driver;

    /*
    Testlerimizi calistirdigimizda herseferinde yeni driver olusturdugu icin her test methodu
    icin yeni bir pencere (driver) aciyor. Eger driver'a bir deger atanmamissa yani driver == null ise
    bir kere driver'i calistir diyerek, bir kere if'in icini calistiracak. Ve driver artik bir kere
    calistigii icin ve deger atandigi icin null olmayacak ve direkt return edecek ve diger
    testlerimiz ayni pencere(driver) uzerinde calisacak
     */

    public static WebDriver getDriver(){
        if (driver == null) { // driver'a deger atanmamissa deger ata
            switch (ConfigReader.getProperty("browser")){


                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
            return driver;

    }

    public static void closeDriver (){
        if (driver!=null) { // driver'a deger atanmissa kapat
            driver.close();
            driver=null; // kapandiktan sonraki acmalari garanti altina almak icin tekrar null yaptik
        }
    }
    public static void quitDriver (){
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}
