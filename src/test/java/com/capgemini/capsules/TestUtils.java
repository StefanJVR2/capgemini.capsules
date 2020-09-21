package com.capgemini.capsules;

import com.capgemini.capsules.client.models.CapsuleResponse;
import com.capgemini.capsules.repositories.models.Capsule;
import com.capgemini.capsules.repositories.models.Mission;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {
    private TestUtils() {
        // Prevent someone trying to instantiate this class
    }

    public static List<Capsule> createMockCapsuleList() {
        Capsule capsule1 = new Capsule();
        capsule1.setCapsuleId("1");
        capsule1.setCapsuleSerial("C102");
        capsule1.setMissions(createMockMissions(capsule1));
        capsule1.setLandings(1);
        capsule1.setOriginalLaunch(OffsetDateTime.now());
        capsule1.setReuseCount(1);
        capsule1.setStatus("Active");


        Capsule capsule2 = new Capsule();
        capsule2.setCapsuleId("2");
        capsule2.setCapsuleSerial("C103");
        capsule2.setMissions(new HashSet<>(Collections.singletonList(createMockMission(capsule2))));
        capsule2.setLandings(1);
        capsule2.setOriginalLaunch(OffsetDateTime.now());
        capsule2.setReuseCount(1);
        capsule2.setStatus("Destroyed");

        return Arrays.asList(capsule1, capsule2);
    }

    public static List<Capsule> createMockActiveCapsuleList() {
        Capsule capsule1 = new Capsule();
        capsule1.setCapsuleId("1");
        capsule1.setCapsuleSerial("C105");
        capsule1.setMissions(createMockMissions(capsule1));
        capsule1.setLandings(1);
        capsule1.setOriginalLaunch(OffsetDateTime.now());
        capsule1.setReuseCount(1);
        capsule1.setStatus("Active");


        Capsule capsule2 = new Capsule();
        capsule2.setCapsuleId("5");
        capsule2.setCapsuleSerial("C105");
        capsule2.setMissions(new HashSet<>(Collections.singletonList(createMockMission(capsule2))));
        capsule2.setLandings(1);
        capsule2.setOriginalLaunch(OffsetDateTime.now());
        capsule2.setReuseCount(1);
        capsule2.setStatus("Active");

        return Arrays.asList(capsule1, capsule2);
    }

    public static Capsule createMockCapsule() {
        Capsule capsule = new Capsule();
        capsule.setCapsuleId("1");
        capsule.setCapsuleSerial("C103");
        capsule.setMissions(createMockMissions(capsule));
        capsule.setLandings(4);
        capsule.setOriginalLaunch(OffsetDateTime.now());
        capsule.setReuseCount(2);
        capsule.setStatus("Active");

        return capsule;
    }

    public static CapsuleResponse createMockClientCapsuleResponse() {
        CapsuleResponse capsuleResponse = new CapsuleResponse();
        capsuleResponse.setCapsuleId("1");
        capsuleResponse.setCapsuleSerial("C103");
        capsuleResponse.setLandings(4);
        capsuleResponse.setReuseCount(2);
        capsuleResponse.setOriginalLaunch(OffsetDateTime.now());
        capsuleResponse.setMissions(createMockClientMissions());
        capsuleResponse.setStatus("Active");

        return capsuleResponse;
    }

    private static List<com.capgemini.capsules.client.models.Mission> createMockClientMissions() {
        com.capgemini.capsules.client.models.Mission mission1 = new com.capgemini.capsules.client.models.Mission();
        mission1.setName("Test Mission");
        mission1.setFlight(1);

        com.capgemini.capsules.client.models.Mission mission2 = new com.capgemini.capsules.client.models.Mission();
        mission2.setName("Test Mission");
        mission2.setFlight(2);

        return Arrays.asList(mission1, mission2);
    }

    private static Set<Mission> createMockMissions(Capsule capsule) {
        Mission mission1 = new Mission();
        mission1.setName("Test Mission");
        mission1.setFlight(1);

        Mission mission2 = new Mission();
        mission2.setName("Test Mission");
        mission2.setFlight(2);

        mission1.setCapsule(capsule);
        mission2.setCapsule(capsule);

        return new HashSet<>(Arrays.asList(mission1, mission2));
    }

    private static Mission createMockMission(Capsule capsule) {
        Mission mission3 = new Mission();
        mission3.setName("Test Mission 3");
        mission3.setFlight(1);

        mission3.setCapsule(capsule);

        return mission3;
    }
}
