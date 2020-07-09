package com.example.hospitalmanagementsystem.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "phone_no")
    String phone_no;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> patients = new ArrayList<Patient>();

    public Doctor() {}

    public Doctor(int id, String name, String phone_no) {
        this.id = id;
        this.name = name;
        this.phone_no = phone_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void addPatients(Patient patients) {
        this.patients.add(patients);
        patients.setDoctor(this);
    }
}
