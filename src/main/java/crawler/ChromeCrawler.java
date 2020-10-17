package crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ChromeCrawler implements Crawler {

    private final File chromeDriverFile;
    private final String chromeDriverPath;
    private ChromeDriverService service = null;

    public ChromeCrawler(String chromeDriverPath) {
        final File chromeDriverFile = new File(chromeDriverPath);
        final String absDriverPath = chromeDriverFile.getAbsolutePath();
        if(!chromeDriverFile.exists() && chromeDriverFile.isFile()) {
            throw new RuntimeException("Not found file. or this is not file. <" + absDriverPath + ">");
        } else  {
            this.chromeDriverFile = chromeDriverFile;
            this.chromeDriverPath = absDriverPath;
        }
    }

    public File getChromeDriverFile() {
        return chromeDriverFile;
    }

    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    @Override
    public void startService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(this.chromeDriverFile)
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @Override
    public void stopService() {
        if(null != service) {
            service.stop();
            service = null;
        }
    }

    @Override
    public void startCrawling(String baseUrl) throws InterruptedException  {
        this.startCrawling(baseUrl, 10);
    }

    @Override
    public void startCrawling(String baseUrl, int sec) throws InterruptedException {
        if (null == service) {
            throw new RuntimeException("Call 'startService()' method before crawling");
        }

        final WebDriver driver = new ChromeDriver(this.service);
        final WebDriverWait wait = new WebDriverWait(driver, sec);


        try {
            driver.get(baseUrl);
            Thread.sleep(1000);  // Let the user actually see something!
        } finally {
            System.out.println("Release crawler resources");
            driver.close();
            stopService();
        }
    }
}
