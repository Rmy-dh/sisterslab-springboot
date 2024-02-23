package com.sisterslab.customeremployee.controller;

import com.sisterslab.customeremployee.model.Customer;
import com.sisterslab.customeremployee.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("{id}")
    public Customer getCustomerById(@PathVariable("id") Long id){
        return  customerService.getCustomerById(id);

    }
    @PutMapping("{id}")
    public String setCustomerName(@PathVariable("id") Long id,@RequestBody Customer customer){
        return  customerService.setCustomerName(id,customer);

    }
    @DeleteMapping("{id}")
    public void deleteCustomerById(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
    }
}
