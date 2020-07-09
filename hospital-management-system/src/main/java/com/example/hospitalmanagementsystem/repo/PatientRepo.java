package com.example.hospitalmanagementsystem.repo;

import com.example.hospitalmanagementsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

    List<Patient> findByDoctorId(int doctorId);

}
