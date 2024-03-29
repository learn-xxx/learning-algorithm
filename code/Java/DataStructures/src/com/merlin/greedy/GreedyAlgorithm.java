package com.merlin.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

    public static void main(String[] args) {
        //创建广播电台，放入到Map中
        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时变量，在遍历过程中，存放遍历过程中的电台覆盖的地区和当前还没覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义一个maxKey，保存在一次遍历过程中，能够覆盖最多未覆盖的地区对应的电台的key值
        //如果maxKey不为null，则加入到selects中

        //HashMap : 添加 put(key,value)  取某个key的值 get(key)  获取全部key keySet()
        //HashSet : 添加 add(value)  添加全部 addAll(HashSet)  与另一个Set取交集(HashSet)
        //          删除全部  removeAll(HashSet)  clear()  清空


        while (allAreas.size() != 0) {
            String maxKey = null;
            //如果allArea是不为0，则表示还没有覆盖到所有的电台
            for (String key : broadcasts.keySet()) {
                tempSet.clear();
                tempSet.addAll(broadcasts.get(key));
                //求出tempSet和allAreas集合的交集
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含未覆盖地区的数量，比maxKey指向的集合地区还多，maxKey需要改变
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //如果发现maxKey!=null,则需要将maxKey加入selects
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区,从allAreas去除
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("得到的选择结果:" + selects);
    }
}
