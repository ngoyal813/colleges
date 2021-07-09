package com.example.colleges.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.colleges.converters.array_list_converter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Entity(tableName = "universities")
public class model {

    @NonNull
    @PrimaryKey
    private String name;

    private String country;

    @SerializedName("state-province")
    private String state;

    @Expose
    @TypeConverters({array_list_converter.class})
    private ArrayList web_pages;


    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public ArrayList getWeb_pages(){
        return web_pages;
    }

    public void setState(String state) {
        this.state = state;
    }

    public model(@NonNull String name, String country, String state , ArrayList web_pages) {
        this.name = name;
        this.country = country;
        this.state = state;
        this.web_pages = web_pages;
    }

    @Override
    public String toString() {
        return "model{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", webpages='" + web_pages + '\'' +
                '}';
    }

}
