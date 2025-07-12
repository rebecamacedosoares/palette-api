package com.palette_api.repository;

import com.palette_api.model.ObraArteModel;
import com.palette_api.model.PintorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PintorRepository extends JpaRepository<PintorModel, Long> {
}
