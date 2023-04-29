package com.virtualMed.brone.service;


import com.virtualMed.brone.model.Doctor;
import com.virtualMed.brone.repository.DoctorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorsRepository repository;

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }
}
