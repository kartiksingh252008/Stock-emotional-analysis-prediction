
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

    public double getSentimentChange() {
        return sentimentChange;
    }



    public double getLastSentiment() {
        return lastSentiment;
    }

    public void setLastSentiment(double lastSentiment) {
        this.lastSentiment = lastSentiment;
    }

    public double getPrice() {
        return price;
    }



    public double getChangePercent() {
        return changePercent;
    }



    public long getVolume() {
        return volume;
    }


    public long getPreviousVolume() {
        return previousVolume;
    }



    public double getSentimentScore() {
        return sentimentScore;
    }



    public double getVolumeChange() {
        return volumeChange;
    }


    public int getFinalScore() {
        return finalScore;
    }



    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
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
