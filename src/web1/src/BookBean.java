package web1.src;

/**
 * Created by double on 8/29/16.
 */

import java.io.*;

public class BookBean {
    // item_id | type_id | type_name    | price | star
    private int item_id;
    private int type_id;
    private String type_name;
    private double price;
    private int star;

    public BookBean()
    {

    }

    public BookBean(int item_id, int type_id, String type_name,
                    double price, int star)
    {
        this.item_id = item_id;
        this.type_id= type_id;
        this.type_name = type_name;
        this.price = price;
        this.star = star;
    }

    public int getItem_id()
    {
        return item_id;
    }
    public int getType_id()
    {
        return type_id;
    }
    public String getType_name()
    {
        return type_name;
    }
    public int getStar()
    {
        return star;
    }
    public double getPrice()
    {
        return price;
    }

    public void setItem_id(int item_id)
    {
        this.item_id = item_id;
    }

    public void setType_id(int type_id)
    {
        this.type_id = type_id;
    }
    public void setType_name(String type_name)
    {
        this.type_name = type_name;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setStar(int star)
    {
        this.star = star;
    }
}
