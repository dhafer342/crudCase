package com.inventiv.crudCase.dto;

public class CaseToUpdateDto {
    String description;

    public CaseToUpdateDto() {
    }

    public CaseToUpdateDto(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
