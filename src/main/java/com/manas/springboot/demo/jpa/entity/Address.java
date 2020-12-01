package com.manas.springboot.demo.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements Serializable {


    private int id;


    private String pin;


    private String country;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Column(name = "pin")
    public String getPin() {
        return pin;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

}
