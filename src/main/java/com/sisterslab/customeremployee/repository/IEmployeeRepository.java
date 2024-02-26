package com.sisterslab.customeremployee.repository;

import com.sisterslab.customeremployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByNameAndSurName(String name,String surName);
    Employee findByTc(String tc);
}
