/*
 * Author Name:
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.mongodb.example.BEJ_C2_S3_P_C.service;

import com.mongodb.example.BEJ_C2_S3_P_C.domain.Customer;
import com.mongodb.example.BEJ_C2_S3_P_C.exception.CustomerNotFoundException;
import com.mongodb.example.BEJ_C2_S3_P_C.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    CustomerRepository customerRepository;

    @Autowired

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomerById(int customerId) throws CustomerNotFoundException  {
        boolean flag = false;
        if(customerRepository.findById(customerId).isEmpty()){
            throw new CustomerNotFoundException();
        }
        else{
            customerRepository.deleteById(customerId);
            flag=true;
        }
        return flag;
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomerByProductName(String productName) throws CustomerNotFoundException {
        if(customerRepository.findAllCustomersFromProductName(productName).isEmpty()){
            throw new CustomerNotFoundException();
        }
        return customerRepository.findAllCustomersFromProductName(productName);
    }
}
