package com.manas.springboot.demo.dto;

import com.manas.springboot.demo.jpa.entity.Address;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

public class StudentDto implements Serializable {

    private int id;

    private String name;

    private String rollNumber;

    private String university;

    public AddressDto address;

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

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }


    public AddressDto getAddress() { return this.address; }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
