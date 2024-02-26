package com.sisterslab.customeremployee.service;

import com.sisterslab.customeremployee.converter.EmployeeConverter;
import com.sisterslab.customeremployee.dto.request.EmployeeRequest;
import com.sisterslab.customeremployee.dto.response.EmployeeResponse;
import com.sisterslab.customeremployee.model.Employee;
import com.sisterslab.customeremployee.repository.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    private final IEmployeeRepository IEmployeeRepository;
    private static final Logger LOGGER= LogManager.getLogger(EmployeeService.class);
    public EmployeeResponse addEmployee(EmployeeRequest employee) {
        // Controlled by employee tc (if employee not exist saved to list)
        if(IEmployeeRepository.findByTc(employee.getTc())==null){
            return EmployeeConverter.convertToEmployeeResponse(
                    IEmployeeRepository.save(EmployeeConverter.convertToEmployee(employee)));
        }
        LOGGER.info("Employee already exist!");
        return null;

    }

    public void deleteEmployeeById(Long id) {
        IEmployeeRepository.deleteById(id);
        LOGGER.info("Employee deleted successfully!");
    }

    public void setEmployeeNameById(Long id, EmployeeRequest employeeRequest) {
        Optional<Employee> oldEmployee= IEmployeeRepository.findById(id);
        if(oldEmployee.isPresent()){
            oldEmployee.get().setName(employeeRequest.getName());
            IEmployeeRepository.save(oldEmployee.get());
            LOGGER.info("Updated!");
        }
    }

    public void deleteByNameAndSurname(String name, String surName) {
       Employee oldEmployee= IEmployeeRepository.findByNameAndSurName(name,surName);
       if(Objects.nonNull(oldEmployee)){
           IEmployeeRepository.deleteById(oldEmployee.getId());
           LOGGER.info("Employee deleted!");
       }else{
           LOGGER.info("Employee not found!");
       }
    }
    public EmployeeResponse getEmployee(Long id) {
        if(id!=null){
            return EmployeeConverter.convertToEmployeeResponse(IEmployeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not exist!")));
        }
        return null;
    }

    public List<EmployeeResponse> getAllEmployee() {
        return IEmployeeRepository.findAll()
                .stream()
                .map(EmployeeConverter::convertToEmployeeResponse)
                .collect(Collectors.toList());
    }
}