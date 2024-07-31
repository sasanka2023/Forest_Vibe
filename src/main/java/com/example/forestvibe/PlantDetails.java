package com.example.forestvibe;

public class PlantDetails {


    private String propertyname;

    private String propertydetails;

    public PlantDetails(String property, String details) {
        this.propertyname = property;
        this.propertydetails = details;
    }




    public String getPropertyname() {
        return propertyname;
    }

    public String getPropertydetails() {
        return propertydetails;
    }
}
