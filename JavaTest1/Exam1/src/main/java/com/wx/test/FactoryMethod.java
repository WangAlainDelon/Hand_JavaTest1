package com.wx.test;

public class FactoryMethod {
    public <T extends BaseInterface> T getProuect(Class<T> c) {
        BaseInterface product = null;
        try {
            product = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
