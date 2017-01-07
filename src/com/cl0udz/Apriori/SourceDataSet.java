package com.cl0udz.Apriori;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cloud on 2017/1/7.
 */
public class SourceDataSet {
    static List<List<String>> srcDataSet;

    public static void readDataSet(String fileName){
        String data = null;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        } catch (IOException e){
            System.out.println("Unable to find " + fileName);
            System.exit(-1);
        }

        try {
            while ((data = br.readLine()) != null) {
                // Split the line with ',' and add the List into srcDataSet
                srcDataSet.add(Arrays.asList(data.split(",")));
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return;
    }

    public FrequentItemSet find1FrequentItemSet(Double minSup){
        FrequentItemSet result = new FrequentItemSet(srcDataSet, minSup);

        return result;
    }
}
