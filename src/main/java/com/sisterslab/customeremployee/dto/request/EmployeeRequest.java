package com.sisterslab.customeremployee.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private String name;
    private String surName;
    private String department;
    private double salary;
    private String email;
    private String tc;
}
