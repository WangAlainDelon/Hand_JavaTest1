package com.wx.text;

import java.sql.Timestamp;
import java.util.Date;

public class City {
    private short city_id;
    private String city_name;
    private short country_id;
    private Timestamp last_update;
    private String country_name;

    public short getCity_id() {
        return city_id;
    }

    public void setCity_id(short city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public short getCountry_id() {
        return country_id;
    }

    public void setCountry_id(short country_id) {
        this.country_id = country_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
