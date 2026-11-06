
package com.example;

public class Stock {
    public Stock(String ticker, String companyName) {
        this.ticker = ticker;
        this.companyName = companyName;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private String ticker;
    private String companyName;

    private double sentimentChange;
    private double lastSentiment;
    private double price;
    private double changePercent;

    private long volume;
    private long previousVolume;

    private double sentimentScore;
    private double volumeChange;

    private int finalScore;
    private String prediction;
}
