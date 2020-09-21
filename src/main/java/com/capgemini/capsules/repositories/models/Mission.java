package com.capgemini.capsules.repositories.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@IdClass(MissionId.class)
public class Mission implements Serializable {
    @Id
    private String name;

    @Id
    private int flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capsuleSerial", nullable = false)
    private Capsule capsule;

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

    public Capsule getCapsule() {
        return capsule;
    }

    public void setCapsule(Capsule capsule) {
        this.capsule = capsule;
    }
}
