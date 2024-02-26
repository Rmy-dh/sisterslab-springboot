package com.sisterslab.customeremployee.service;

import com.sisterslab.customeremployee.model.Customer;
import com.sisterslab.customeremployee.repository.ICustomerRepository;
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
    private final ICustomerRepository ICustomerRepository;
    private static final Logger LOGGER= LogManager.getLogger(ICustomerRepository.class);
    public Customer addCustomer(Customer customer) {
        return ICustomerRepository.save(customer);

    }

    public List<Customer> getAllCustomers() {
        return  ICustomerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer= ICustomerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }else{
            LOGGER.info("Customer not exist !");
            return  null;
        }
    }

    public String setCustomerName(Long id, Customer customer) {
        Optional<Customer> customerOptional= ICustomerRepository.findById(id);
        if(customerOptional.isPresent()){
            Customer oldCustomer=customerOptional.get();
            oldCustomer.setName(customer.getName());
            ICustomerRepository.save(oldCustomer);
            return "Success";
        }
        return  "Failed";
    }

    public void deleteCustomerById(Long id) {
        ICustomerRepository.deleteById(id);
    }
}
