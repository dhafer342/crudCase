package com.inventiv.crudCase.dto;

import java.time.LocalDateTime;

public class CaseDto{

    String title;
    String description;
    java.time.LocalDateTime creationDate;
    LocalDateTime lastUpdateDate;

    public CaseDto() {
    }

    public CaseDto(String title, String description, LocalDateTime creationDate, LocalDateTime lastUpdateDate) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
