package com.example.hospitalmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "phone_no")
    String phone_no;

    @Column(name = "prescription")
    String prescription;

    @PrimaryKeyJoinColumn
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Doctor doctor;

    public Patient() {}

    public Patient(int id, String name, String phone_no, String prescription) {
        this.id = id;
        this.name = name;
        this.phone_no = phone_no;
        this.prescription = prescription;
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

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
