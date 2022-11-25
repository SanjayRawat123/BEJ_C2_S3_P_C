/*
 * Author Name:
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.mongodb.example.BEJ_C2_S3_P_C.repository;

import com.mongodb.example.BEJ_C2_S3_P_C.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

    @Query("{'customerProduct.productName':{$in:[?0]}}")
    List<Customer> findAllCustomersFromProductName(String productName);



}
