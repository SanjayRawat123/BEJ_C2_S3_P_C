package com.mongodb.example.BEJ_C2_S3_P_C.service;

import com.mongodb.example.BEJ_C2_S3_P_C.domain.Customer;
import com.mongodb.example.BEJ_C2_S3_P_C.exception.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {

    Customer saveCustomer(Customer customer)  ;

    boolean deleteCustomerById(int customerId)throws CustomerNotFoundException;

    List<Customer> getAllCustomers() throws Exception;

    List<Customer>getCustomerByProductName(String productName) throws CustomerNotFoundException;



}
