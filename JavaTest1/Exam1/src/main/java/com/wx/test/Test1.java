package com.wx.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Test1 {
    /**
     * 随机生成50个小于100的整数，放入List中，将List中的数据除以10，以结果的整数值作为key放入Map中，得到
     * 如{1=>[11,10,12],2=>[21,24,23]}的Map，再将Map中key对应的数组进行排序，得到如{1=>
     * [10,11,12],2=>[21,23,24]}。排序不能使用List.sort() 方法。必须自己写排序方法。
     * 要求：
     * 使用工厂模式，创建一个接口类和两个实现类（4分）
     * 创建一个工厂，生成基于给定信息的实体类的对象。（2分）
     * 在main 函数中，通过上面的工厂获取到唯一的类。（2分）
     * 两个实现类分别使用java 8 的Stream 和其他方式（4分）
     * 实现功能 （3分）
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int num = random.nextInt(100);
            list.add(num);
        }
        //用工厂创建实例
        FactoryMethod factoryMethod=new FactoryMethod();
        MappingDate mapdata = factoryMethod.getProuect(MappingDate.class);
        SortDate sortDate = factoryMethod.getProuect(SortDate.class);
        //映射数据
        Map map = mapdata.doData(list);
        //完成排序
        Map<Integer, Integer[]> map1 = sortDate.doData(map);
        for (Integer integer : map1.keySet()) {
            System.out.print(integer+":");
            Integer[] integers = map1.get(integer);
            for (Integer integer1 : integers) {
                System.out.print(integer1+",");
            }
            System.out.println("");
        }
    }
}
