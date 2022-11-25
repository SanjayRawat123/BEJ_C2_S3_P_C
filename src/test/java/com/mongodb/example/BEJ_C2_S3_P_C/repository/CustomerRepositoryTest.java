/*
 * Author Name:
 * Date: 11/25/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.mongodb.example.BEJ_C2_S3_P_C.repository;

import com.mongodb.example.BEJ_C2_S3_P_C.domain.Customer;
import com.mongodb.example.BEJ_C2_S3_P_C.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Product product;
    private Customer customer;


    @BeforeEach
    void setUp(){
        product = new Product(1,"Apple","ear Phone");
        customer = new Customer(1,"ram","9756037495",product);
    }

    @AfterEach
    void tearDown(){

        product = null;
        customer = null;
        customerRepository.deleteAll();

    }

    @Test
    @DisplayName("Test case for saving customer object")

    public  void givenCustomerToSaveReturnSaveCustomer(){
        customerRepository.save(customer);
        customerRepository.save(customer);
        Customer customer1=customerRepository.findById(customer.getCustomerId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getCustomerId(),customer1.getCustomerId());

    }
    @Test
    @DisplayName("Test case for deleting customer object")
    public void givenCustomerToDeleteShouldDeleteCustomer() {
        customerRepository.insert(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.delete(customer1);
        assertEquals(Optional.empty(), customerRepository.findById(customer.getCustomerId()));
    }
    @Test
    @DisplayName("Test Case for retrieving all the customer object")
    void givenCustomerReturnAllCustomerDetail() {
        customerRepository.insert(customer);
        product = new Product(2, "Vivo", "Mobile");
        customer = new Customer(2, "Ramesh", "112765436", product);
        customerRepository.insert(customer);

        List<Customer> list = customerRepository.findAll();
        assertEquals(2, list.size());
        assertNotEquals(6, list.size());
        assertEquals("Ramesh", list.get(1).getCustomerName());
        assertNotEquals("Ram", list.get(1).getCustomerName());


    }
    @Test
    @DisplayName("Test Case for retrieving all the customer by product Name")
    public void getCustomerReturnAllProductName(){
        customerRepository.insert(customer);
        product=new Product(2,"Vivo","Mobile");
        customer=new Customer(2,"Ramesh","112765436",product);
        customerRepository.insert(customer);
        List<Customer> customers=customerRepository.findAllCustomersFromProductName(customer.getCusromerProduct().getProuductName());
        assertEquals(1,customers.size());
        assertEquals(customer.getCusromerProduct().getProuductName(),customers.get(0).getCusromerProduct().getProuductName());
    }
}
