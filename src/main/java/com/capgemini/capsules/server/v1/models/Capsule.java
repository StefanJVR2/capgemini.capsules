package com.capgemini.capsules.server.v1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Capsule {
    @JsonProperty("capsule_serial")
    private String capsuleSerial;

    @JsonProperty("capsule_id")
    private String capsuleId;

    private String status;

    @JsonProperty("original_launch")
    private OffsetDateTime originalLaunch;

    private BigDecimal landings;

    private BigDecimal reuseCount;

    private List<Mission> missions = null;

    public Capsule capsuleSerial(String capsuleSerial) {
        this.capsuleSerial = capsuleSerial;
        return this;
    }

    public String getCapsuleSerial() {
        return capsuleSerial;
    }

    public void setCapsuleSerial(String capsuleSerial) {
        this.capsuleSerial = capsuleSerial;
    }

    public Capsule capsuleId(String capsuleId) {
        this.capsuleId = capsuleId;
        return this;
    }

    public String getCapsuleId() {
        return capsuleId;
    }

    public void setCapsuleId(String capsuleId) {
        this.capsuleId = capsuleId;
    }

    public Capsule status(String status) {
        this.status = status;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Capsule originalLaunch(OffsetDateTime originalLaunch) {
        this.originalLaunch = originalLaunch;
        return this;
    }

    public OffsetDateTime getOriginalLaunch() {
        return originalLaunch;
    }

    public void setOriginalLaunch(OffsetDateTime originalLaunch) {
        this.originalLaunch = originalLaunch;
    }

    public Capsule landings(BigDecimal landings) {
        this.landings = landings;
        return this;
    }

    public BigDecimal getLandings() {
        return landings;
    }

    public void setLandings(BigDecimal landings) {
        this.landings = landings;
    }

    public Capsule reuseCount(BigDecimal reuseCount) {
        this.reuseCount = reuseCount;
        return this;
    }

    public BigDecimal getReuseCount() {
        return reuseCount;
    }

    public void setReuseCount(BigDecimal reuseCount) {
        this.reuseCount = reuseCount;
    }

    public Capsule missions(List<Mission> missions) {
        this.missions = missions;
        return this;
    }

    public Capsule addMissionsItem(Mission missionsItem) {
        if (this.missions == null) {
            this.missions = new ArrayList<>();
        }
        this.missions.add(missionsItem);
        return this;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}

