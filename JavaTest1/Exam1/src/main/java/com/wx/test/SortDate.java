package com.wx.test;

import java.util.Map;

public class SortDate implements BaseInterface<Map> {
    @Override
    public Map doData(Map collection) {
        Map<Integer, Integer[]> collection1 = (Map<Integer, Integer[]>) collection;
        for (Integer integer : collection1.keySet()) {
            collection1.put(integer, sort(collection1.get(integer)));
        }
        return collection1;
    }

    //排序方法,希尔排序，是插入排序的一种
    private static Integer[] sort(Integer[] array) {
        int len = array.length;
        int temp;
        //设置增量,增量是数据长度的一半依次减一减到一
        for (int k = len / 2; k > 0; k--) {
            //将依据增量分割的序列进行对比
            for (int i = k; i < len; i++) {
                if (array[i - k] > array[i]) {
                    //交换数据
                    temp = array[i - k];
                    array[i - k] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
