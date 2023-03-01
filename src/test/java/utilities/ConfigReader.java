package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {// her method'dan once calisir
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis); // fis'in okudugu bilgileri properties'e yukledi
// FileInputStream olusturdugumuzda bir try catch olusturduk. properties.load(fis); dedikten sonra bir try catch daha atadi
            // ancak IOException exception'unu atayinca; onceki try catch'i sildik. gerek kalmadi cunku IOException genis kapsamli
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static String getProperty(String key){
        /*
        Test Methodundan yolladigimiz String key degerini alip
        Properties class'indan getProperty() methodunu kullanarak
        bu key'e ait value'yu bize getirir
         */

        return properties.getProperty(key);
    }



}
