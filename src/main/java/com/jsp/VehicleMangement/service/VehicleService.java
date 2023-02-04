package com.jsp.VehicleMangement.service;

import com.jsp.VehicleMangement.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle saveVehicle(Vehicle vehicle);

    String deleteVehicleById(Integer vid);

    Vehicle updateVehicleById(Vehicle vehicle);

    Vehicle getVehicleByid(Integer vid);

    List<Vehicle> getAllByColor(String color);

    List<Vehicle> getAllVehicles();

    List<Vehicle> sortByPrice();

    List<Vehicle> findByPrice(Double price);

    List<Vehicle> findByPriceAndColorSorted();
}
