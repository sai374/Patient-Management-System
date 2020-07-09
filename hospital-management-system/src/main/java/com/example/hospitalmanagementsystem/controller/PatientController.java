package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.exception.NotFoundException;
import com.example.hospitalmanagementsystem.model.Patient;
import com.example.hospitalmanagementsystem.repo.DoctorRepo;
import com.example.hospitalmanagementsystem.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @GetMapping("/{doctorId}/patients")
    public List<Patient> getPatientsUnderDoctor(@PathVariable int doctorId) {
        if(!doctorRepo.existsById(doctorId)) {
            throw new NotFoundException("Employee not found!");
        }
        return patientRepo.findByDoctorId(doctorId);
    }

    @PostMapping(value = "/{doctorId}/patients", produces = "application/json")
    public Patient addPatients(@PathVariable int doctorId,
                               @Validated @RequestBody Patient patients) {
        return doctorRepo.findById(doctorId)
                .map(doctor -> {
                    patients.setDoctor(doctor);
                    return patientRepo.save(patients);
                }).orElseThrow(()->new NotFoundException("Employee not found!"));
    }

    @PutMapping("/doctors/{doctorId}/patients/{patientId}")
    public Patient updatePatientDetails(@PathVariable int doctorId,
                                        @PathVariable int patientId,
                                        @Validated @RequestBody Patient patientDetailsUpdated) {
        if(!doctorRepo.existsById(doctorId)) {
            throw new NotFoundException("Employee not found!");
        }
        return patientRepo.findById(patientId)
                .map(patients -> {
                    patients.setName(patientDetailsUpdated.getName());
                    patients.setPhone_no(patientDetailsUpdated.getPhone_no());
                    patients.setPrescription(patientDetailsUpdated.getPrescription());
                    return patientRepo.save(patients);
                }).orElseThrow(()-> new NotFoundException("Patient is not found!"));
    }

    @DeleteMapping("doctors/{doctorId}/patients/{patientId}")
    public String deleteAddress(@PathVariable int doctorId,
                                @PathVariable int patientId) {
        if(!doctorRepo.existsById(doctorId)) {
            throw new NotFoundException("Doctor not found!");
        }
        return patientRepo.findById(patientId)
                .map(patients -> {
                    patientRepo.delete(patients);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Patient not found!"));
    }

}
