package com.wx.text;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Test1 {
    /**
     * 使用sakila 数据库。
     * 下载地址：http://pan.hand-china.com/owncloud/index.php/s/0ZvHkqUaXpkFqW9。 密码：
     * handhand。
     * 下载成功之后，根据sakila-schema.sql 和sakila-data.sql 来创建数据库和数据。
     * 程序使用mysql + jdbc。 不得使用spring。
     * 要求：
     * 根据 Country ID。返回所有属于这个 Country 的 CityID 及名称。（10分）
     * 程序中使用的Country ID 和Customer ID 需要从配置文件变量中读取
     */
    public static void main(String[] args) {
        /**
         * 根据 Country ID。返回所有属于这个 Country 的 CityID 及名称
         */
        try {
            DBUtils dbUtils = new DBUtils();
            Properties prop = new Properties();
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("peizhi.properties");
            prop.load(inputStream);
            String country_id = prop.getProperty("Country_ID");
            String sql = "SELECT a.*,b.country FROM city a JOIN country b ON a.country_id=b.country_id AND b.country_id= ?";
            List list = new ArrayList();
            list.add(country_id);
            ResultSet resultSet = dbUtils.query(sql, list);
            String re;
            List<City> cities = new ArrayList<City>();
            try {
                while (resultSet.next()) {
                    City city = new City();
                    city.setCity_id(resultSet.getShort("city_id"));
                    city.setCity_name(resultSet.getString("city"));
                    city.setCountry_id(resultSet.getShort("country_id"));
                    city.setCountry_name(resultSet.getString("country"));
                    city.setLast_update(resultSet.getTimestamp("last_update"));
                    cities.add(city);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Country ID:" + cities.get(0).getCountry_id() + "|" + "Country" + cities.get(0).getCountry_name() + "的城市");
            for (City city1 : cities) {
                /**
                 * Country ID: id
                 * Country `name` 的城市
                 * 城市 ID | 城市名称
                 * 1 | A Corua (La Corua)
                 * ... | ...
                 */
                System.out.println("城市ID：" + city1.getCity_id() + "|" + "城市名称" + city1.getCity_name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
