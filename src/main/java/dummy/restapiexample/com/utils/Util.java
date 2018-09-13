package dummy.restapiexample.com.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import dummy.restapiexample.com.datamodel.Employee;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by udit on 11/09/18.
 */
public class Util {
    public static String getValue(String key){
        Properties config = new Properties();

        try {
            String file = "config.properties";
            InputStream inputStream = Util.class.getClassLoader().getResourceAsStream(file);
            config.load(inputStream);
        } catch (Throwable t){
            System.out.print("Failed to load config");
            t.printStackTrace();
        }

        return config.getProperty(key);

    }

    public static String buildUrl(){
        return getValue("protocol")+getValue("url");
    }
    public static Employee setEmployeeProfile(String user){

        ObjectMapper mapper = new ObjectMapper();
        Employee employee = null;
        String file = System.getProperty("user.dir") + "/src/main/resources/userProfile/user-" + user + ".json";

        try {
            employee = mapper.readValue(new File(file), Employee.class);
        } catch (Exception e) {
            System.out.print("setEmployeeProfile: Failed to read json file");
            e.printStackTrace();
        }

        return employee;
    }
}
