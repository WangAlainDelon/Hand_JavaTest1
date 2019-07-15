package com.wx.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingDate implements BaseInterface<List> {
    @Override
    public Map doData(List collection) {
        List<Integer> list = (List) collection;
        Map<Integer, List<Integer>> collect1 = list.stream()
                .collect(Collectors.groupingBy(o -> (Integer) (o / 10)));
        //但是要求需要将List<Integer>转化为数组
        Map<Integer, Integer[]> collect2 = new HashMap<Integer, Integer[]>();
        for (Integer integer : collect1.keySet()) {
            List<Integer> list1 = collect1.get(integer);
            Integer[] array = list1.stream().toArray(Integer[]::new);
            collect2.put(integer, array);
        }
        return collect2;
    }
}
