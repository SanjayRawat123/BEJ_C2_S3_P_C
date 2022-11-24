/*
 * Author Name:
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.mongodb.example.BEJ_C2_S3_P_C.domain;

public class Product {
    private int prouductId;
    private String prouductName;
    private String prouductDescription;

    public Product() {
    }

    public Product(int prouductId, String prouductName, String prouductDescription) {
        this.prouductId = prouductId;
        this.prouductName = prouductName;
        this.prouductDescription = prouductDescription;
    }

    public int getProuductId() {
        return prouductId;
    }

    public Product setProuductId(int prouductId) {
        this.prouductId = prouductId;
        return this;
    }

    public String getProuductName() {
        return prouductName;
    }

    public Product setProuductName(String prouductName) {
        this.prouductName = prouductName;
        return this;
    }

    public String getProuductDescription() {
        return prouductDescription;
    }

    public Product setProuductDescription(String prouductDescription) {
        this.prouductDescription = prouductDescription;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prouductId=" + prouductId +
                ", prouductName='" + prouductName + '\'' +
                ", prouductDescription='" + prouductDescription + '\'' +
                '}';
    }
}
