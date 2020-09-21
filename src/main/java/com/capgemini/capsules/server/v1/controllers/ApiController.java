package com.capgemini.capsules.server.v1.controllers;

import com.capgemini.capsules.server.v1.models.Capsule;
import com.capgemini.capsules.server.v1.workers.ApiWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/spacex-proxy")
public class ApiController {
    private final Logger logger = LoggerFactory.getLogger(ApiController.class);
    private final ApiWorker worker;

    @Autowired
    public ApiController(ApiWorker worker) {
        this.worker = worker;
    }

    /**
     * GET /capsules : Get all capsules information in the services memory store.
     * This call does not fetch information from SpaceX, it only retrieves what has been looked up/posted using /capsules/{capsule_serial}
     *
     * @return OK (status code 200)
     * or No capsules found in memory store (status code 204)
     * or Could not retrieve capsule data from memory store (status code 412)
     */
    @GetMapping(path = "/capsules", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Capsule>> getAllCapsules() {
        logger.info("com.capgemini.spacex.capsules.getAllCapsules");

        return worker.getAllCapsules();
    }

    /**
     * GET /capsules/active : Get all active capsules information in the services memory store.
     * This call does not fetch information from SpaceX, it only retrieves what has been looked up/posted using /capsules/{capsule_serial}
     *
     * @return OK (status code 200)
     * or No capsules found in memory store (status code 204)
     * or Could not retrieve capsule data from memory store (status code 412)
     */
    @GetMapping(path = "/capsules/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Capsule>> getAllActiveCapsules() {
        logger.info("com.capgemini.spacex.capsules.getAllCapsules");

        return worker.getAllActiveCapsules();
    }

    /**
     * POST /capsules/{capsule_serial} : Save capsule information
     *
     * @param capsuleSerial (required)
     * @return Created (status code 201)
     * or Could not add capsule data to memory store (status code 412)
     */
    @PostMapping(path = "/capsules/{capsule_serial}")
    public ResponseEntity<Void> createCapsuleData(@PathVariable("capsule_serial") String capsuleSerial) {
        logger.info("com.capgemini.spacex.capsules.createCapsuleData");

        return worker.createCapsuleData(capsuleSerial);
    }

    /**
     * DELETE /capsules/{capsule_serial} : Delete capsule information
     *
     * @param capsuleSerial (required)
     * @return OK (status code 204)
     * or Could not delete capsule from in memory store (status code 412)
     */
    @DeleteMapping(path = "/capsules/{capsule_serial}")
    public ResponseEntity<Void> deleteCapsuleData(@PathVariable("capsule_serial") String capsuleSerial) {
        logger.info("com.capgemini.spacex.capsules.deleteCapsuleData");

        return worker.deleteCapsuleData(capsuleSerial);
    }

    /**
     * GET /capsules/{capsule_serial} : Get details about a specific SpaceX capsule, including launches landings and crashes
     *
     * @param capsuleSerial (required)
     * @return OK (status code 200)
     * or Nothing found (status code 204)
     * or Could not fetch capsule details (status code 412)
     */
    @GetMapping(path = "/capsules/{capsule_serial}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Capsule> getCapsuleData(@PathVariable("capsule_serial") String capsuleSerial) {
        logger.info("com.capgemini.spacex.capsules.getCapsuleData");

        return worker.getCapsuleData(capsuleSerial);
    }
}
