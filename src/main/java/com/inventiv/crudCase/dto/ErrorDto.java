package com.inventiv.crudCase.dto;

public class ErrorDto {
    String errorDetails;

    public ErrorDto(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
}
