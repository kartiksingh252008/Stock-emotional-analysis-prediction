
package com.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderService {
    public static List<Stock> readStocks(String[] args) throws IOException, CsvValidationException {
            List<Stock> stocks = new ArrayList<>();
            CSVReader reader = new CSVReader(
                    new FileReader("/Users/kartik/Desktop/emotion-analysis-stock/data/social_sentiment_stocktwits_chginsentiment_bearish_03-15-2022.csv")
            );
            String[] row  ;

            reader.readNext() ; // skip headings

            while((row = reader.readNext()) !=null){

            }
    }
    }

