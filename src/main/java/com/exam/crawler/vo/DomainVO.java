package com.exam.crawler.vo;

public class DomainVO {
    private String protocol;
    private String baseUrl;

    // Constructor
    public DomainVO(){
    }
    public DomainVO(String baseUrl) {
        this("http", baseUrl);
    }
    public DomainVO(String protocol, String baseUrl) {
        this.protocol = protocol;
        this.baseUrl = baseUrl;
    }

    // Access method
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        final String lowerStrProtocol = protocol.toLowerCase();
        if("http".equals(lowerStrProtocol) || "https".equals(lowerStrProtocol)) {
            this.protocol = lowerStrProtocol;
        }
        throw new RuntimeException("Invalid value for protocol. " + protocol);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String toString() {
        return "DomainVO{" +
                "protocol='" + protocol + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                '}';
    }
}
