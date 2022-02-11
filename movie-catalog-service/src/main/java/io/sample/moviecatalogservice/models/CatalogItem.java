package io.sample.moviecatalogservice.models;

public class CatalogItem {

    private String name;
    private String desc;
    private int rating;

    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
}

