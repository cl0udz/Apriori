package com.cl0udz.Apriori;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by cloud on 2017/1/7.
 */
public class FrequentItemSet {
    private int k;
    private Double minSup;
    private List<List<String>> frequentItemSet;
    private List<List<String>> candidateItemSet;
    private Map<List<String>, Integer> count;

    FrequentItemSet(List<List<String>> defaultSet, Double minSupArg){
        candidateItemSet = defaultSet;
        minSup = minSupArg;
        findFrequentSet();
    }

    private void findFrequentSet(){

    }

    public void selfJoin(){

    }

    public FrequentItemSet generateNextFrequentSet(){
        selfJoin();
        FrequentItemSet result = new FrequentItemSet(candidateItemSet, minSup);
        return result;
    }
}
