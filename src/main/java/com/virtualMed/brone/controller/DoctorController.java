package com.virtualMed.brone.controller;

import com.virtualMed.brone.model.Doctor;
import com.virtualMed.brone.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")

@RequiredArgsConstructor
@RequestMapping("/api/v2/doctor")
public class DoctorController {

    private final DoctorService service;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors(){
        return service.getAllDoctors();
    }
}