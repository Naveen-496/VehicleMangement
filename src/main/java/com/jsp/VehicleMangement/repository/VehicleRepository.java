package com.jsp.VehicleMangement.repository;

import com.jsp.VehicleMangement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle , Integer> {

      List<Vehicle> findByvcolor(String color);

      List<Vehicle> findByvpriceGreaterThan(Double price);


}
