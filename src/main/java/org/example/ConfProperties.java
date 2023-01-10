package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    private static Properties properties = new Properties();
    public static String getProperty(String key) {
        try(FileInputStream FIS = new FileInputStream("src\\test\\resources\\conf.properties")) {
            properties.load(FIS);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }



}
