package com.capgemini.capsules.server.v1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Mission {
    @JsonProperty("name")
    private String name;

    @JsonProperty("flight")
    private BigDecimal flight;

    public Mission name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mission flight(BigDecimal flight) {
        this.flight = flight;
        return this;
    }

    public BigDecimal getFlight() {
        return flight;
    }

    public void setFlight(BigDecimal flight) {
        this.flight = flight;
    }
}

