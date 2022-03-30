package com.ebookfrenzy.uifyp;

public class Product {

    public String itemName, itemCategory,itemCondition;
    public int itemPrice;

    public Product(){


    }

    public Product(String itemName, String itemCategory, String itemCondition, int itemPrice){
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemCondition = itemCondition;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }
}
