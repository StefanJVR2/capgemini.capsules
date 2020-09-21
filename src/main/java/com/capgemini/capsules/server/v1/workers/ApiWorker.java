package com.capgemini.capsules.server.v1.workers;

import com.capgemini.capsules.client.models.CapsuleResponse;
import com.capgemini.capsules.repositories.CapsuleRepository;
import com.capgemini.capsules.server.v1.mappers.EntityModelMapper;
import com.capgemini.capsules.server.v1.mappers.ResponseModelMapper;
import com.capgemini.capsules.server.v1.models.Capsule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class ApiWorker {
    private static final String ACTIVE = "active";
    private final RestTemplate restTemplate;
    private final ResponseModelMapper responseModelMapper;
    private final EntityModelMapper entityModelMapper;
    private final CapsuleRepository capsuleRepository;
    private final String spacexUrl;

    @Autowired
    public ApiWorker(RestTemplate restTemplate, ResponseModelMapper responseModelMapper, EntityModelMapper entityModelMapper,
                     CapsuleRepository capsuleRepository, @Value("${spacex.capsules.url}") String spacexUrl) {

        this.restTemplate = restTemplate;
        this.responseModelMapper = responseModelMapper;
        this.entityModelMapper = entityModelMapper;
        this.capsuleRepository = capsuleRepository;
        this.spacexUrl = spacexUrl;
    }

    public ResponseEntity<List<Capsule>> getAllCapsules() {
        List<com.capgemini.capsules.repositories.models.Capsule> capsuleList = capsuleRepository.findAll();

        if (capsuleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(entityModelMapper.convert(capsuleList), HttpStatus.OK);
    }

    public ResponseEntity<List<Capsule>> getAllActiveCapsules() {
        List<com.capgemini.capsules.repositories.models.Capsule> capsuleList = capsuleRepository.findAllByStatusIgnoreCase(ACTIVE);

        if (capsuleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(entityModelMapper.convert(capsuleList), HttpStatus.OK);
    }

    public ResponseEntity<Void> createCapsuleData(String capsuleSerial) {
        try {
            CapsuleResponse response = restTemplate.getForObject(spacexUrl, CapsuleResponse.class, capsuleSerial);

            com.capgemini.capsules.repositories.models.Capsule capsule = responseModelMapper.convert(response);
            capsule.getMissions().forEach(mission -> mission.setCapsule(capsule));

            capsuleRepository.save(capsule);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RestClientException rce) {

            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }

    public ResponseEntity<Void> deleteCapsuleData(String capsuleSerial) {

        if (capsuleRepository.findById(capsuleSerial).isPresent()) {
            capsuleRepository.deleteById(capsuleSerial);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Capsule> getCapsuleData(String capsuleSerial) {
        if (!capsuleRepository.findById(capsuleSerial).isPresent()) {
            createCapsuleData(capsuleSerial);
        }

        Optional<com.capgemini.capsules.repositories.models.Capsule> optionalCapsule = capsuleRepository.findById(capsuleSerial);
        return optionalCapsule.map(value -> new ResponseEntity<>(entityModelMapper.convert(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED));
    }
}
