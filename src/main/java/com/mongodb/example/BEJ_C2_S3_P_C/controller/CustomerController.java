/*
 * Author Name:
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.mongodb.example.BEJ_C2_S3_P_C.controller;

import com.mongodb.example.BEJ_C2_S3_P_C.domain.Customer;
import com.mongodb.example.BEJ_C2_S3_P_C.exception.CustomerNotFoundException;
import com.mongodb.example.BEJ_C2_S3_P_C.service.CustomerService;
import com.mongodb.example.BEJ_C2_S3_P_C.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    CustomerService customerService;

    @Autowired

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/costomersdata")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping(value = "/customerget")
    public ResponseEntity<?> getCustomer() {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);

        } catch (Exception e) {
             e.printStackTrace();
        }
return responseEntity;
    }


    @DeleteMapping(value = "/customer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
        ResponseEntity responseEntity =null;
        try {
            customerService.deleteCustomerById(customerId);
            responseEntity = new ResponseEntity<>("successfully deleted one record",HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping(value = "/customer/{productName}")
    public ResponseEntity<?> getAllCustomersByProductName(@PathVariable String productName) throws CustomerNotFoundException{
        ResponseEntity responseEntity=null;
        try{
            responseEntity=new ResponseEntity(customerService.getCustomerByProductName(productName),HttpStatus.OK);

        } catch (CustomerNotFoundException e) {

            throw new CustomerNotFoundException();
        }
        return responseEntity;
    }
}
