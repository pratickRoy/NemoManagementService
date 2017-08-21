package com.extnds.nemo.commons.exceptions;

public class InternalServerException extends RuntimeException {

    public InternalServerException(Exception e) {
        super(e);
    }
}
