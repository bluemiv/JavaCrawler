package main;

import crawler.ChromeCrawler;
import crawler.Crawler;
import util.PropertiesReader;

import java.io.File;

public class Main
{
    public static void main( String[] args ) throws Exception {
        // properties 파일을 읽어옴
        final PropertiesReader pr = new PropertiesReader("src/main/resources/config/config_local.properties");
        final String driverPath = pr.getDriverPath();
        System.out.println("driverPath: " + driverPath);
        final String driverType = pr.getDriverType();
        System.out.println("driverType: " + driverType);

        // Crawler 객체 생성
        Crawler crawler;
        if ("chrome".equalsIgnoreCase(driverType)) {
            crawler = new ChromeCrawler(driverPath);
        } else {
            throw new RuntimeException("Invalid value for driver type.");
        }

        // 실행
        final String baseUrl = pr.getBaseUrl();
        System.out.println("baseUrl: " + baseUrl);
        crawler.startService();
        crawler.startCrawling(baseUrl);
    }
}
