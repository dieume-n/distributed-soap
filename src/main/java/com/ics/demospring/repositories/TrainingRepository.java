package com.ics.demospring.repositories;

import com.ics.demospring.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}
