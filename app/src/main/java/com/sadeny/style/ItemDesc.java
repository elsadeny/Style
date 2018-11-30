package com.sadeny.style;

import android.graphics.Bitmap;


//this is the model class to hold item description and properties
//Sadeny Alpha
public class ItemDesc {
    private String item_name;
    private String item_price;
    private Bitmap item_pic;

    //default constructor
    public ItemDesc(){}

    //constructor with args
    public ItemDesc(String item_name,String item_price,Bitmap item_pic)
    {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_pic = item_pic;
    }

    //public gateway to the external classes
    //and getter functions
    public String getItemName(){return item_name;}
    public String getItem_price(){return item_price;}
    public Bitmap getItem_pic(){return item_pic;}

    //public gateway to the external classes
    //and setter functions
    public void setItem_name(String item_name){this.item_name=item_name;}
    public void setItem_price(String item_price){this.item_price=item_price;}
    public void setItem_pic(Bitmap item_pic){this.item_pic=item_pic;}

}


