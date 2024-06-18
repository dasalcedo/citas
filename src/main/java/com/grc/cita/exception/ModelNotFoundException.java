package com.grc.cita.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String mensaje) {
        super(mensaje);
    }
}
