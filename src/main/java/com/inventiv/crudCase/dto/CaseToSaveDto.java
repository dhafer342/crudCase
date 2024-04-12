package com.inventiv.crudCase.dto;

public class CaseToSaveDto {
    String title;
    String description;

    public CaseToSaveDto() {
    }

    public CaseToSaveDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
