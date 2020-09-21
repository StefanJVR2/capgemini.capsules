package com.capgemini.capsules.repositories.models;

import java.io.Serializable;
import java.util.Objects;

public class MissionId implements Serializable {
    private String name;

    private int flight;

    public MissionId() {

    }

    public MissionId(String name, int flight) {
        this.name = name;
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionId missionId = (MissionId) o;
        return flight == missionId.flight &&
                name.equals(missionId.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flight);
    }
}