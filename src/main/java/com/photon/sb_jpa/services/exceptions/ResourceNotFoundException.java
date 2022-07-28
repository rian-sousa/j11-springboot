package com.photon.sb_jpa.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id){
        super("Resource Not Found. ID " + id);
    }
    
}
