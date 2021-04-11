package com.soheyl.NumberConverter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.soheyl.NumberConverter.entity.Conversion;
import com.soheyl.NumberConverter.entity.RomanConversionService;
import com.soheyl.NumberConverter.util.INumberConverter;
import com.soheyl.NumberConverter.wrapper.IConvertWrapper;
import com.soheyl.NumberConverter.wrapper.NumberType;
import com.soheyl.NumberConverter.wrapper.NumberWrapper;

/**
 * Number Converter Controller
 * 
 * @author Soheyl Nazifi
 *
 */
@RestController
@RequestMapping("/convert")
public class ConverterController {
    
    @Autowired
    IConvertWrapper  wrapper;
    
    @Autowired
    INumberConverter convert;

    @Autowired
    RomanConversionService conversionService;
    
    @RequestMapping("decimal/{number}")
    public String fromLong(@PathVariable(value = "number") String number) {
        return convert.toRoman(number, NumberType.Decimal);
    }
    
    @RequestMapping("binary/{number}")
    public String FromBinary(@PathVariable(value = "number") String number) {
        return convert.toRoman(number, NumberType.Binary);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public NumberWrapper toRoman(@RequestBody NumberWrapper numbersWrapper) {
        return wrapper.convert(numbersWrapper);
    }
    
    @GetMapping(value = "/")
    public List<Conversion> getAll() {
        return conversionService.getAll();
    }
}
