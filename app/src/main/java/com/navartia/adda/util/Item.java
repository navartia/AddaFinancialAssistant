package com.navartia.adda.util;

public abstract class Item {
    public String name;
    public int id;

    public Item() {
        name = "";
        id = 0;
    }

    public Item(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
