package com.soheyl.NumberConverter.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RomanConversionService {
 
    @Autowired
    ConversionRepository repository;
 
    public List<Conversion> getAll() {
        List<Conversion> conversions = new ArrayList<Conversion>();
        repository.findAll().forEach(conversion -> conversions.add(conversion));
        return conversions;
    }
 
    public Conversion getConversionById(int id) {
        return repository.findById(id).get();
    }
 
    public void saveOrUpdate(Conversion conversion) {
        repository.save(conversion);
    }
 
    public void delete(int id) {
        repository.deleteById(id);
    }
}