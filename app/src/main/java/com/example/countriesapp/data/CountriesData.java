package com.example.countriesapp.data;

import java.io.Serial;
import java.io.Serializable;

public class CountriesData implements Serializable {
    private String name, full_name, currency, capital_name, region, sub_region, maps, flag;
    private double lat, lng, area, population;
    private String[] borders;

    public CountriesData() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCapital_name() {
        return capital_name;
    }

    public void setCapital_name(String capital_name) {
        this.capital_name = capital_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSub_region() {
        return sub_region;
    }

    public void setSub_region(String sub_region) {
        this.sub_region = sub_region;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String[] getBorders() {
        return borders;
    }

    public void setBorders(String[] borders) {
        this.borders = borders;
    }
}
