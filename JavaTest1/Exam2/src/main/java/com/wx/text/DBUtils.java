package com.wx.text;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBUtils {
    //配置文件的路径
    private static final String dbconfig = "jdbc.properties";
    private static Properties prop = new Properties();
    private static Connection conn = null;
    private PreparedStatement predtatement = null;
    private ResultSet rst = null;

    public DBUtils() {
        conn = getConnection();
    }
    static {
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(dbconfig);
            prop.load(inputStream);
            String driverClassName = prop.getProperty("driverClassName");
            Class.forName(driverClassName);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            System.out.println(prop.getProperty("url"));
            return conn=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void close() {
        try {
            if (predtatement != null) {
                this.predtatement.close();
            }
            if (rst != null) {
                this.rst.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("Close connection success.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int executeUpdate(String sql, List<String> sqlValues) {
        int result = -1;
        try {
            predtatement = conn.prepareStatement(sql);
            if (sqlValues != null && sqlValues.size() > 0) {
                setSqlValues(predtatement, sqlValues);
            }
            result = predtatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    private void setSqlValues(PreparedStatement pst, List<String> sqlValues) {
        for (int i = 0; i < sqlValues.size(); i++) {
            try {
                pst.setObject(i + 1, sqlValues.get(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public ResultSet query(String sql, List<String> sqlValues) {
        ResultSet resultSet = null;
        try {
            predtatement = conn.prepareStatement(sql);
            if (sqlValues != null && sqlValues.size() > 0) {
                setSqlValues(predtatement, sqlValues);
            }
            resultSet = predtatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


}
