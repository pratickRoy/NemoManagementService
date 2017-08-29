package com.extnds.nemo.managementservice.commons.exceptions;

public class InternalServerException extends RuntimeException {

    public InternalServerException(Exception e) {
        super(e);
    }
}
