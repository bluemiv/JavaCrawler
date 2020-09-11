package com.exam;

import com.exam.crawler.vo.DomainVO;
import junit.framework.TestCase;

public class CrawlerTest extends TestCase {

    public void testCrawler() {
        final DomainVO domainVo = new DomainVO("http", "naver.com");
        System.out.println(domainVo);
        assertEquals("http", domainVo.getProtocol());
        assertEquals("naver.com", domainVo.getBaseUrl());
    }
}
