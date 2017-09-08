package com.company.weedlook.collectionweed.models;

import com.orm.SugarRecord;


/**
 * Created by osx on 23-08-17.
 */

public class Favorite extends SugarRecord {

    private String name, variety;
    private boolean toforget;


    public Favorite() {


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public boolean istoforget() {
        return toforget;
    }

    public void setToforget(boolean toforget) {
        this.toforget = toforget;
    }


}
