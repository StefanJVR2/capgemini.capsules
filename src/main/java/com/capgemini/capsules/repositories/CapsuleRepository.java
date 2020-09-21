package com.capgemini.capsules.repositories;


import com.capgemini.capsules.repositories.models.Capsule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapsuleRepository extends JpaRepository<Capsule, String> {
    List<Capsule> findAllByStatusIgnoreCase(String status);
}
