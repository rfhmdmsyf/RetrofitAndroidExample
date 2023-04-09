package com.example.retrofitandroidexample.model;

import com.google.gson.annotations.SerializedName;

public class Diskon {


    @SerializedName("diskonName")
    private String diskonName;

    public Diskon( String diskonName) {

        this.diskonName = diskonName;
    }



    public String getDiskonName() {
        return diskonName;
    }

    public void setDiskonName(String diskonName) {
        this.diskonName = diskonName;
    }
}
