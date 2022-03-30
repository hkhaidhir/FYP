package com.ebookfrenzy.uifyp.model;

public class FeaturedProduct {

    Integer id;
    Integer imageurl;

    public FeaturedProduct(Integer id, Integer imageurl){
        this.id = id;
        this.imageurl = imageurl;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageurl() {
        return imageurl;
    }

    public void setImageurl(Integer imageurl) { this.imageurl = imageurl; }
}
