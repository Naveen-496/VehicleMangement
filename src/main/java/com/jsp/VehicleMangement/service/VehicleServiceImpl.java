package com.jsp.VehicleMangement.service;

import com.jsp.VehicleMangement.exception.VehicleNotFoundException;
import com.jsp.VehicleMangement.model.Vehicle;
import com.jsp.VehicleMangement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private VehicleRepository vehicleRepo;
    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        vehicleRepo.save(vehicle);
        return vehicle;
    }

    @Override
    public String deleteVehicleById(Integer vid) {

        Vehicle vehicle = vehicleRepo.findById(vid).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle Does Not Exist with ID "+ vid)
        );
        if( vehicle != null) {
            vehicleRepo.deleteById(vid);
            return "Vehicle Deleted Successfully";
        }

        return "No Vehicle Found By ID " + vid;
    }

    @Override
    public Vehicle updateVehicleById(Vehicle vehicle) {
        Vehicle uveh = vehicleRepo.findById(vehicle.getVid()).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle Does Not Exist")
        );
        if( uveh != null){
            uveh.setVname(vehicle.getVname());
            uveh.setVcolor(vehicle.getVcolor());
            uveh.setVprice(vehicle.getVprice());
            uveh.setVmodel(vehicle.getVmodel());
            vehicleRepo.save(uveh);

            return uveh;
        }
        return null;
    }

    @Override
    public Vehicle getVehicleByid(Integer vid) {

        return vehicleRepo.findById(vid).orElseThrow(
                () ->  new VehicleNotFoundException("Vehicle with ID " + vid + " Not Exist "));
    }

    @Override
    public List<Vehicle> getAllByColor(String color) {
        return vehicleRepo.findByvcolor(color);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @Override
    public List<Vehicle> sortByPrice() {
        return vehicleRepo.findAll(Sort.by(Sort.Direction.ASC , "vprice"));
    }

    @Override
    public List<Vehicle> findByPrice(Double price) {
        return  vehicleRepo.findByvpriceGreaterThan(price);
    }

    @Override
    public List<Vehicle> findByPriceAndColorSorted() {
        List<Vehicle> vehicles = getAllVehicles();

        Comparator<Vehicle> comp = (v1, v2) -> {
                if( v1.getVprice() < v2.getVprice())
                    return -1;
                else if( v1.getVprice() > v2.getVprice())
                    return 1;
                else
                return v1.getVcolor().compareTo(v2.getVcolor());

        };

        Collections.sort(vehicles , comp);

        return vehicles;
    }


}
