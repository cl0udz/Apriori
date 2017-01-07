package com.cl0udz.Apriori;

/**
 * Created by cloud on 2016/12/29.
 */

import javax.xml.transform.Source;
import java.util.List;

public class AprioriMining {
    private static Double minSup = 0.0;
    private int minConf;

    public static void main(String[] args) {
        SourceDataSet srcDataSet = new SourceDataSet();
        FrequentItemSet frequentSet = null;

        minSup = Double.parseDouble(args[1]);

        // read source data set from file args[0]
        srcDataSet.readDataSet(args[0]);
        // generate 1-frequent item set
        frequentSet = srcDataSet.find1FrequentItemSet(minSup);

        // generate frequent item set until no more frequent item is found
        while (frequentSet.generateNextFrequentSet() != null){
            ;
        }

        return;
    }

}
//
//// 找出频繁 1 项集
//        L1 =find_frequent_1-itemsets(D);
//                For(k=2;Lk-1 !=null;k++){
//// 产生候选，并剪枝
//                Ck =apriori_gen(Lk-1 );
//// 扫描 D 进行候选计数
//                For each 事务t  in D{
//                Ct =subset(Ck,t); // 得到 t 的子集
//                For each 候选 c 属于 Ct
//                c.count++;
//                }
//                //返回候选项集中不小于最小支持度的项集
//                Lk ={c 属于 Ck | c.count>=min_sup}
//                }
//                Return L= 所有的频繁集；
//                第一步：连接（join）
//                Procedure apriori_gen (Lk-1 :frequent(k-1)-itemsets)
//                For each 项集 l1 属于 Lk-1
//                For each 项集 l2 属于 Lk-1
//                If( (l1 [1]=l2 [1])&&( l1 [2]=l2 [2])&& ……&& (l1 [k-2]=l2 [k-2])&&(l1 [k-1]<l2 [k-1]) )
//        then{
//        c = l1 连接 l2    // 连接步：产生候选
//        //若k-1项集中已经存在子集c则进行剪枝
//        if has_infrequent_subset(c, Lk-1 ) then
//        delete c; // 剪枝步：删除非频繁候选
//        else add c to Ck;
//        }
//        Return Ck;
//        第二步：剪枝（prune）
//        Procedure has_infrequent_sub (c:candidate k-itemset; Lk-1 :frequent(k-1)-itemsets)
//        For each (k-1)-subset s of c
//        If s 不属于 Lk-1 then
//        Return true;
//        Return false