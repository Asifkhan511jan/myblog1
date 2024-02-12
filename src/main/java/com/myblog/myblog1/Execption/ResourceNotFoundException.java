package com.myblog.myblog1.Execption;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
    super(message);
    }
}
