package com.virtualMed.brone.repository;

import com.virtualMed.brone.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorsRepository extends JpaRepository<Doctor, Long> {
}
