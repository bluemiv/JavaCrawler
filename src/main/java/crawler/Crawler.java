package crawler;

import java.io.IOException;

public interface Crawler {

    public void startService() throws IOException;

    public void stopService();

    public void startCrawling(String baseUrl) throws InterruptedException ;

    public void startCrawling(String baseUrl, int sec) throws InterruptedException ;
}
