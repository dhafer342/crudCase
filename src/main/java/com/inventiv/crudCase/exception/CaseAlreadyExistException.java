package com.inventiv.crudCase.exception;

public class CaseAlreadyExistException extends RuntimeException{
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param title the name of the Case.
     */
    public CaseAlreadyExistException(String title) {
        super("Case with title "+title+" already exist.");
    }
}
