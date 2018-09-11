package dummy.restapiexample.com.utils;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by udit on 11/09/18.
 */
public class Config {
    public static String getValue(String key){
        Properties config = new Properties();

        try {
            String file = "config.properties";
            InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(file);
            config.load(inputStream);
        } catch (Throwable t){
            System.out.print("Failed to load config");
            t.printStackTrace();
        }

        return config.getProperty(key);

    }

    public static String buildUrl(String endpoint){
        return getValue("protocol")+getValue("url")+"/"+getValue(endpoint+".uri");
    }
}
