package com.sisterslab.customeremployee.controller;


import com.sisterslab.customeremployee.dto.request.EmployeeRequest;
import com.sisterslab.customeremployee.dto.response.EmployeeResponse;
import com.sisterslab.customeremployee.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping()
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest employee){
        return employeeService.addEmployee(employee);

    }
    @DeleteMapping("{id}")
    public void deleteEmployeeById(@PathVariable("id")Long id){
        employeeService.deleteEmployeeById(id);
    }

    @DeleteMapping("/employee")
    public void deleteByNameAndSurname(@RequestParam String name,@RequestParam String surName){
        employeeService.deleteByNameAndSurname(name,surName);

    }
    @PutMapping("{id}")
    public void setEmployeeNameById(@PathVariable("id") Long id, @RequestBody EmployeeRequest employeeRequest){
         employeeService.setEmployeeNameById(id,employeeRequest);
    }
    @GetMapping("/{id}")
    public EmployeeResponse getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/list")
    public List<EmployeeResponse> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

}
