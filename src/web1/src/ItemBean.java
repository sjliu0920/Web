package web1.src;

/**
 * Created by double on 8/29/16.
 */

public class ItemBean {
    // item_id | type_id | type_name    | price | star
    private int level_1_id;
    private int level_2_id;
    private String item_name;
    private double item_price;
    private int item_star;

    public ItemBean()
    {

    }

    public ItemBean(int level_1_id, int level_2_id, String item_name,
                    double item_price, int item_star)
    {
        this.level_1_id = level_1_id;
        this.level_2_id = level_2_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_star = item_star;
    }

    public int getLevel_1_id()
    {
        return level_1_id;
    }
    public int getLevel_2_id()
    {
        return level_2_id;
    }
    public String getItem_name()
    {
        return item_name;
    }
    public int getItem_star()
    {
        return item_star;
    }
    public double getItem_price()
    {
        return item_price;
    }

    public void setLevel_1_id(int level_1_id)
    {
        this.level_1_id = level_1_id;
    }

    public void setLevel_2_id(int level_2_id)
    {
        this.level_2_id = level_2_id;
    }
    public void setItem_name(String item_name)
    {
        this.item_name = item_name;
    }
    public void setItem_price(double item_price )
    {
        this.item_price = item_price;
    }
    public void setItem_star(int item_star)
    {
        this.item_star = item_star;
    }
}
