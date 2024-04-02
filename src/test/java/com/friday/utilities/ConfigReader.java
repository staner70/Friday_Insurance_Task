package com.friday.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            String path = "config.properties";

            // dosyayi java diline okur veya dondurur
            FileInputStream fileInputStream = new FileInputStream(path);

            properties = new Properties();

            // verileri dosyadan key / value seklinde yukler
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
}
