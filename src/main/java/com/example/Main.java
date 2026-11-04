package com.example;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {

        CSVReader reader = new CSVReader(
                new FileReader("/Users/kartik/Desktop/emotion-analysis-stock/data/social_sentiment_stocktwits_chginsentiment_bearish_03-15-2022.csv")
        );

        String[] row;

        reader.readNext(); // Skip header remeber

        while ((row = reader.readNext()) != null) {

            String ticker = row[0];

            double sentimentChange = Double.parseDouble(row[1]);
            double lastSentiment = Double.parseDouble(row[2]);
            double sentimentChangePercent = Double.parseDouble(row[3]);

            int rank = Integer.parseInt(row[4]);

            String companyName = row[5];

            double price = Double.parseDouble(row[6]);
            double priceChange = Double.parseDouble(row[7]);
            double changePercent = Double.parseDouble(row[8]);

            long volume = Long.parseLong(row[9]);
            long marketCap = Long.parseLong(row[10]);
            long previousVolume = Long.parseLong(row[11]);

            double previousClose = Double.parseDouble(row[12]);

            System.out.println("Stock: " + ticker);
            System.out.println("Company: " + companyName);
            System.out.println("Sentiment Change: " + sentimentChange);
            System.out.println("Last Sentiment: " + lastSentiment);
            System.out.println("Price: " + price);
            System.out.println("Trading Volume: " + volume);
            System.out.println("Trading Volume: " + previousVolume);
            double score = (0.7 * lastSentiment)
                    + (0.3 * sentimentChange);
            boolean trending ;
            if(((previousVolume - volume)/previousVolume)*100 > 0){
                trending = true ;
            }
            else {
                trending = false ;
            }

            String prediction;
            if (score > 5) {
                prediction = "BULLISH &&" + " trending = " + trending;
            } else if (score < -5 ) {
                prediction = "BEARISH &&" + " trending = " + trending;
            } else {
                prediction = "NEUTRAL && trending = " + trending;
            }
            System.out.println("Combined Score: " + score);
            System.out.println("Prediction: " + prediction);

            System.out.println("Sentiment Signal: " + prediction);
            String priceSignal;

            if (changePercent > 0) {
                priceSignal = "UPWARD";
            } else if (changePercent < 0) {
                priceSignal = "DOWNWARD";
            } else {
                priceSignal = "STABLE";
            }

            System.out.println("Price Movement: " + priceSignal);
            System.out.println("-------------------------");
        }

        reader.close();

    }
}