/*
 * Author Name:
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.mongodb.example.BEJ_C2_S3_P_C.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    @Id
    private int customerId;
    private String customerName;
    private String customerPhoneNo;
    private Product cusromerProduct;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerPhoneNo, Product cusromerProduct) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.cusromerProduct = cusromerProduct;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Customer setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Customer setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public Customer setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
        return this;
    }

    public Product getCusromerProduct() {
        return cusromerProduct;
    }

    public Customer setCusromerProduct(Product cusromerProduct) {
        this.cusromerProduct = cusromerProduct;
        return this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNo='" + customerPhoneNo + '\'' +
                ", cusromerProduct=" + cusromerProduct +
                '}';
    }
}
