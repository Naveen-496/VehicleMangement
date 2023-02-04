package com.jsp.VehicleMangement.controllers;

import com.jsp.VehicleMangement.exception.VehicleNotFoundException;
import com.jsp.VehicleMangement.model.Vehicle;
import com.jsp.VehicleMangement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
   @PostMapping("/vehicle/add")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.saveVehicle(vehicle);
    }
     @GetMapping("/vehicle/{vid}")
    public Vehicle getVehicleById(@PathVariable("vid") Integer vid){
       return vehicleService.getVehicleByid(vid);
    }
    @PutMapping("/vehicle/upt")
    public Vehicle updateVehicleByid(@RequestBody Vehicle vehicle){

       return vehicleService.updateVehicleById(vehicle);
    }

    @DeleteMapping("/vehicle/{vid}")
    public String deleteVehicle(@PathVariable("vid") Integer vid){
       return vehicleService.deleteVehicleById(vid);
    }

    @GetMapping("/vehicle")
    public List<Vehicle> getAllVehicles(){
       return vehicleService.getAllVehicles();
    }
    @GetMapping("/vehicle/color/{color}")
    public List<Vehicle> getAllByColor(@PathVariable("color") String color){
       return vehicleService.getAllByColor(color);
    }
    @GetMapping("vehicle/sort")
    public List<Vehicle> sortByPriceAll(){
       return vehicleService.sortByPrice();
    }
    @GetMapping("/vehicle/price/{price}")
    public List<Vehicle> getAllGreaterThan(@PathVariable("price") Double price){
       return vehicleService.findByPrice(price);
    }
    @GetMapping("/vehicle/byp&c")
    public List<Vehicle> getAllByPriceAndColorSorted(){
       return vehicleService.findByPriceAndColorSorted();
    }
    @RequestMapping("")
    public String welcomeMessage(){
       return "Welcome To BikeDekho";
    }

}
