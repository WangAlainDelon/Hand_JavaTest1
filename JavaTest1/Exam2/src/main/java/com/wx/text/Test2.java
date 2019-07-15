package com.wx.text;

import java.io.InputStream;
import java.util.Properties;

public class Test2 {
    /**
     * 根据 Customer ID。返回这个Customer中租的所的 Film，按租用时间倒排序。
     */
    public static void main(String[] args) throws Exception {
        DBUtils dbUtils = new DBUtils();
        Properties prop = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("peizhi.properties");
        prop.load(inputStream);
        String Customer_ID = prop.getProperty("Customer_ID");


    }
}
