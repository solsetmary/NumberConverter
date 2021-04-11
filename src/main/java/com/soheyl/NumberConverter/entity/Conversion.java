package com.soheyl.NumberConverter.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.soheyl.NumberConverter.wrapper.NumberType;

@Entity
@Table(name = "Conversion")
public class Conversion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private String     number;
    private String     convert;
    @Enumerated(EnumType.STRING)
    private NumberType type;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    
    public String getConvert() {
        return convert;
    }
    
    public void setConvert(String convert) {
        this.convert = convert;
    }
    
    public NumberType getType() {
        return type;
    }
    
    public void setType(NumberType type) {
        this.type = type;
    }
}