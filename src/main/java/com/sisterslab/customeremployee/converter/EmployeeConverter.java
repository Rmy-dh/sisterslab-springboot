package com.sisterslab.customeremployee.converter;

import com.sisterslab.customeremployee.dto.request.EmployeeRequest;
import com.sisterslab.customeremployee.dto.response.EmployeeResponse;
import com.sisterslab.customeremployee.model.Employee;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeeConverter {
    public static Employee convertToEmployee(EmployeeRequest employeeRequest){
        Employee employee=new Employee();
        employee.setName(employeeRequest.getName());
        employee.setSurName(employeeRequest.getSurName());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setEmail(employeeRequest.getEmail());
        employee.setSalary(employeeRequest.getSalary());
        employee.setTc(employeeRequest.getTc());

        return employee;
    }
    public static EmployeeResponse convertToEmployeeResponse(Employee employee){
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setName(employee.getName());
        employeeResponse.setSurName(employee.getSurName());
        employeeResponse.setDepartment(employee.getDepartment());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setStartDate(employee.getStartDate());
        return employeeResponse;

    }
}
