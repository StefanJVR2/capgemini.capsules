package com.capgemini.capsules.repositories.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
public class Capsule {
    @Id
    private String capsuleSerial;

    private String capsuleId;

    private String status;

    private OffsetDateTime originalLaunch;

    private int landings;

    private int reuseCount;

    @OneToMany(mappedBy = "capsule", cascade = CascadeType.ALL)
    private Set<Mission> missions;

    public Capsule() {
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

    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }
}
