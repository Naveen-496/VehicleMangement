package com.jsp.VehicleMangement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer vid;

    private String vname;

    private Double vprice;

    private String vcolor;

    private String vmodel;
}
