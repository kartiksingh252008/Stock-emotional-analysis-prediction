//
//package com.example;
//
//import com.opencsv.CSVReader;
//import java.io.FileReader;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//public class Main {
//    public static void main(String[] args) throws Exception {
//
//        CSVReader reader = new CSVReader(
//                new FileReader()
//        );
//
//        String[] row;
//
//        reader.readNext(); // Skip header imp
//
//        Connection con = DBConnection.getConnection();
//
//        String sql = "INSERT INTO stock_analysis " +
//                "(ticker, company_name, sentiment_score, volume_change, " +
//                "price_change_percent, final_score, prediction) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//        PreparedStatement ps = con.prepareStatement(sql);
//
//        while ((row = reader.readNext()) != null) {
//
//            String ticker = row[0];
//
//            double sentimentChange = Double.parseDouble(row[1]);
//            double lastSentiment = Double.parseDouble(row[2]);
//            double sentimentChangePercent = Double.parseDouble(row[3]);
//
//            int rank = Integer.parseInt(row[4]);
//
//            String companyName = row[5];
//
//            double price = Double.parseDouble(row[6]);
//            double priceChange = Double.parseDouble(row[7]);
//            double changePercent = Double.parseDouble(row[8]);
//
//            long volume = Long.parseLong(row[9]);
//            long marketCap = Long.parseLong(row[10]);
//            long previousVolume = Long.parseLong(row[11]);
//
//            double previousClose = Double.parseDouble(row[12]);
//
//            System.out.println("Stock: " + ticker);
//            System.out.println("Company: " + companyName);
//            System.out.println("Sentiment Change: " + sentimentChange);
//            System.out.println("Last Sentiment: " + lastSentiment);
//            System.out.println("Price: " + price);
//            System.out.println("Trading Volume: " + volume);
//            System.out.println("Previous Volume: " + previousVolume);
//
//            double score = (0.7 * lastSentiment)
//                    + (0.3 * sentimentChange);
//
//            System.out.println("Combined Score: " + score);
//
//            double volumeChange = 0;
//
//            if (previousVolume > 0) {
//                volumeChange = ((double) (volume - previousVolume)
//                        / previousVolume) * 100;
//            }
//
//            System.out.println("Volume Change: " + volumeChange + "%");
//
//            boolean trending;
//
//            if (volumeChange > 20) {
//                trending = true;
//            } else {
//                trending = false;
//            }
//
//            System.out.println("Trending: " + trending);
//
//            String priceSignal;
//
//            if (changePercent > 0) {
//                priceSignal = "UPWARD";
//            } else if (changePercent < 0) {
//                priceSignal = "DOWNWARD";
//            } else {
//                priceSignal = "STABLE";
//            }
//
//            System.out.println("Price Movement: " + priceSignal);
//
//            // 4. Combined prediction algorithm
//            int finalScore = 0;
//
//            if (score > 5) {
//                finalScore += 2;
//            } else if (score < -5) {
//                finalScore -= 2;
//            }
//
//            if (volumeChange > 20) {
//                finalScore += 1;
//            } else if (volumeChange < -20) {
//                finalScore -= 1;
//            }
//
//            if (changePercent > 0) {
//                finalScore += 1;
//            } else if (changePercent < 0) {
//                finalScore -= 1;
//            }
//
//            String finalPrediction;
//
//            if (finalScore >= 2) {
//                finalPrediction = "BULLISH";
//            } else if (finalScore <= -2) {
//                finalPrediction = "BEARISH";
//            } else {
//                finalPrediction = "NEUTRAL";
//            }
//
//            System.out.println("Final Score: " + finalScore);
//            System.out.println("Final Prediction: " + finalPrediction);
//
//            System.out.println("-------------------------");
//            ps.setString(1, ticker);
//            ps.setString(2, companyName);
//            ps.setDouble(3, score);
//            ps.setDouble(4, volumeChange);
//            ps.setDouble(5, changePercent);
//            ps.setInt(6, finalScore);
//            ps.setString(7, finalPrediction);
//
//            ps.executeUpdate();
//
//            System.out.println("Stock saved successfully!");
//        }
//        con.close();
//        ps.c
//        reader.close();
//    }
//}
