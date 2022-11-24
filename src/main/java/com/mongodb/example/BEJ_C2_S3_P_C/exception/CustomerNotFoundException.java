/*
 * Author Name:
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.mongodb.example.BEJ_C2_S3_P_C.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer Not Found")
public class CustomerNotFoundException extends Exception {
}
