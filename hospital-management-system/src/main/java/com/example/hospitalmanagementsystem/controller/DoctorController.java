package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.model.Doctor;
import com.example.hospitalmanagementsystem.repo.DoctorRepo;
import com.example.hospitalmanagementsystem.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    //private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorRepo doctorRepo;

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        doctorService.create(doctor);
        return doctor;
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = "application/json")
    public List<Doctor> showAllDoctors() { return doctorService.showAllDoctors(); }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<Doctor> showDoctorById(@PathVariable(name = "id") int id) { return doctorService.showDoctorById(id); }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    public Doctor updateDoctor(@PathVariable(name = "id") int id,
                               @Validated @RequestBody Doctor updatedDoctor) {
        return doctorService.update(id, updatedDoctor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable(name = "id") int id) {doctorService.deleteDoctor(id); }

}
