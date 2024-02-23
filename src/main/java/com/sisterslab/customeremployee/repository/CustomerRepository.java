package com.sisterslab.customeremployee.repository;

import com.sisterslab.customeremployee.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
