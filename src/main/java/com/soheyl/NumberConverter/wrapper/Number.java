package com.soheyl.NumberConverter.wrapper;

public class Number {
    
    private String     number;
    private String     convert;
    private NumberType type;
    
    public String getNumber() {
        return number;
    }
    
    public Number setNumber(String number) {
        this.number = number;
        return this;
    }
    
    public String getConvert() {
        return convert;
    }
    
    public Number setConvert(String convert) {
        this.convert = convert;
        return this;
    }
    
    public NumberType getType() {
        return type;
    }
    
    public Number setType(NumberType type) {
        this.type = type;
        return this;
    }
    
}
