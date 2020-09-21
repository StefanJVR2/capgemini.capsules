package com.capgemini.capsules.client.models;

public class Mission {
    private String name;

    private int flight;

    public Mission() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }
}
