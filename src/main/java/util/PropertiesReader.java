package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader(String propertiesPath) {
        try {
            // 파일 확인
            final File propertiesFile = new File(propertiesPath);
            if (!propertiesFile.exists() || !propertiesFile.isFile()) {
                throw new RuntimeException("Not found file or this is not file. <" + propertiesPath + ">");
            }

            // 프로퍼티 파일 읽어옴
            final FileInputStream fis = new FileInputStream(propertiesPath);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath() {
        return this.properties.getProperty("driver.file.path");
    }

    public String getDriverType() {
        return this.properties.getProperty("driver.file.type");
    }

    public String getBaseUrl() {
        return this.properties.getProperty("baseurl");
    }
}
