package com.studio21.controller;

import com.studio21.model.ServiceItem;
import com.studio21.service.ServiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServiceItemController {

    @Autowired
    private ServiceItemService serviceItemService;

    @GetMapping("/service")
    public List<ServiceItem> getServiceList(){
        return serviceItemService.findAll();
    }

    @GetMapping("/service/{id}")
    public Optional<ServiceItem> getService(@PathVariable int id){
        return serviceItemService.findById(id);
    }

    @PostMapping("/service")
    public String addService(@RequestBody ServiceItem serviceItem){
        if (serviceItem!=null){
            serviceItemService.save(serviceItem);
        }

        return "Item saved successfully";
    }

    @PutMapping("/service")
    public String updateItem(@RequestBody ServiceItem serviceItem){
        if (serviceItem!=null){
            serviceItemService.save(serviceItem);
        }

        return "Item updated successfully";
    }

    @DeleteMapping("/service/{id}")
    public String deleteItem(@PathVariable int id){
        if (id>0){
            if (serviceItemService.findById(id).isPresent()){
                serviceItemService.delete(serviceItemService.findById(id).get());
            }
        }

        return "Item deleted successfully";
    }
}
