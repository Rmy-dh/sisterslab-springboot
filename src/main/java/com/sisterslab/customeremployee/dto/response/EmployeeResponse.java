package com.sisterslab.customeremployee.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeResponse {
    private String name;
    private String surName;
    private String department;
    private String email;
    private Date startDate;
}
