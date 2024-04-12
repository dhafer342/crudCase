package com.inventiv.crudCase.exception;

public class CaseNotFoundException extends RuntimeException{

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CaseNotFoundException(String message) {
        super("Case with title "+message+" does not exist.");
    }
}
