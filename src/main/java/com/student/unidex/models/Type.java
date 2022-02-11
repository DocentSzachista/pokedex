package com.student.unidex.models;

import jakarta.persistence.*;

@Entity(name = "Types")
@Table
public class Type {

    @Id
    @GeneratedValue
    private Long typeId;

    @Column(nullable = false)
    private String typeName;

    public Type() {
    }



    public Type(Long typeId, String typeName){
        this.typeId = typeId;

        this.typeName = typeName;
    }

    // getters and setters

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
