package com.inventiv.crudCase.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caseId")
    private long id;
    @Column
    private LocalDateTime creationDate;
    @Column
    private LocalDateTime lastUpdateDate;
    @Column(nullable = false,unique = true)
    private String title;
    @Column(length = 2056, nullable = false)
    private String description;

    public CaseEntity() {

    }

    public CaseEntity(LocalDateTime creationDate, LocalDateTime lastUpdateDate, String title, String description) {
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.title = title;
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
