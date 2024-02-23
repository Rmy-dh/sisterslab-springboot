package com.sisterslab.customeremployee.service;

import com.sisterslab.customeremployee.model.Customer;
import com.sisterslab.customeremployee.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private static final Logger LOGGER= LogManager.getLogger(CustomerRepository.class);
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);

    }

    public List<Customer> getAllCustomers() {
        return  customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer=customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }else{
            LOGGER.info("Customer not exist !");
            return  null;
        }
    }

    public String setCustomerName(Long id, Customer customer) {
        Optional<Customer> customerOptional=customerRepository.findById(id);
        if(customerOptional.isPresent()){
            Customer oldCustomer=customerOptional.get();
            oldCustomer.setName(customer.getName());
            customerRepository.save(oldCustomer);
            return "Success";
        }
        return  "Failed";
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
