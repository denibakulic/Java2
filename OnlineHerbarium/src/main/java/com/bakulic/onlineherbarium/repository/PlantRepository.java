package com.bakulic.onlineherbarium.repository;

import com.bakulic.onlineherbarium.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

    Plant findById(int id);
}