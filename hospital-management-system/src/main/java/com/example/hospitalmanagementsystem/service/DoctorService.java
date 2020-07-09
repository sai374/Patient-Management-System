package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.exception.NotFoundException;
import com.example.hospitalmanagementsystem.model.Doctor;
import com.example.hospitalmanagementsystem.repo.DoctorRepo;
import com.example.hospitalmanagementsystem.repo.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    public DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    //private static final Logger LOG = LoggerFactory.getLogger(DoctorService.class);

    public List<Doctor> showAllDoctors() {
        System.out.println("making a call to repo...");
        return doctorRepo.findAll();
    }

    public void create(Doctor doctor) {
        doctorRepo.save(doctor);
        System.out.println("Created successfully");
    }

    public Optional<Doctor> showDoctorById(int id) {
        System.out.println("making a call to repo...");
        Optional<Doctor> optDoctor = doctorRepo.findById(id);
        if(optDoctor.isPresent()) {
            return doctorRepo.findById(id);
        }else {
            throw new NotFoundException("Doctor not found with id " + id);
        }
    }

    /*public List<Employee> showEmployeeInfoUsingName(String name) {
        System.out.println("making a call to repo...");
        List<Employee> employee = doctorRepo.findByName(name);
        return employee;
    }

    public List<Employee> sortingEmployeeByNameInAsc() {
        System.out.println("making a call to repo...");
        List<Employee> employee = doctorRepo.findByNameInAscOrder();
        return employee;
    }*/

    public Doctor update(int id, Doctor doctorDetailsUpdated) {
        System.out.println("Updated successfully");
        return doctorRepo.findById(id)
                .map(doctor -> {
                    doctor.setName(doctorDetailsUpdated.getName());
                    doctor.setPhone_no(doctorDetailsUpdated.getPhone_no());
                    return doctorRepo.save(doctor);
                }).orElseThrow(() -> new NotFoundException("Doctor not found with id " + id));
    }

    public String deleteDoctor(int id) {
        return doctorRepo.findById(id)
                .map(doctor -> {
                    doctorRepo.delete(doctor);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Doctor not found with id " + id));
    }
}



