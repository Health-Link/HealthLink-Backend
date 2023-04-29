package com.virtualMed.brone.controller;

import com.virtualMed.brone.model.Doctor;
import com.virtualMed.brone.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/doctor")
public class DoctorController {

    private final DoctorService service;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors(){
        return service.getAllDoctors();
    }
}