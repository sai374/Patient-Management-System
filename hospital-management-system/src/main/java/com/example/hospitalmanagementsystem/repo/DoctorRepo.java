package com.example.hospitalmanagementsystem.repo;

import com.example.hospitalmanagementsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

    Optional<Doctor> findById(int id);

}
