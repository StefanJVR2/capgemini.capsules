package com.capgemini.capsules.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.List;

public class CapsuleResponse {
    @JsonProperty("capsule_serial")
    private String capsuleSerial;

    @JsonProperty("capsule_id")
    private String capsuleId;

    private String status;

    @JsonProperty("original_launch")
    private OffsetDateTime originalLaunch;

    private int landings;

    @JsonProperty("reuse_count")
    private int reuseCount;

    private List<Mission> missions;

    public CapsuleResponse() {

    }

    public String getCapsuleSerial() {
        return capsuleSerial;
    }

    public void setCapsuleSerial(String capsuleSerial) {
        this.capsuleSerial = capsuleSerial;
    }

    public String getCapsuleId() {
        return capsuleId;
    }

    public void setCapsuleId(String capsuleId) {
        this.capsuleId = capsuleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getOriginalLaunch() {
        return originalLaunch;
    }

    public void setOriginalLaunch(OffsetDateTime originalLaunch) {
        this.originalLaunch = originalLaunch;
    }

    public int getLandings() {
        return landings;
    }

    public void setLandings(int landings) {
        this.landings = landings;
    }

    public int getReuseCount() {
        return reuseCount;
    }

    public void setReuseCount(int reuseCount) {
        this.reuseCount = reuseCount;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
