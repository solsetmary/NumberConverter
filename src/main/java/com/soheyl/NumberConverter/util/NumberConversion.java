package com.soheyl.NumberConverter.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soheyl.NumberConverter.entity.Conversion;
import com.soheyl.NumberConverter.entity.RomanConversionService;
import com.soheyl.NumberConverter.wrapper.NumberType;

@Service
public class NumberConversion implements INumberConverter {
    
    @Autowired
    IRomanUtil roman;

    @Autowired
    RomanConversionService conversionService;
    
    @Override
    public String toRoman(String number, NumberType type) {
        Conversion conversion = new Conversion();
        conversion.setNumber(number);
        conversion.setType(type);
        try {
            switch (type) {
                case Decimal:
                    conversion.setConvert(roman.number(Integer.parseInt(number)));
                    break;
                case Binary:
                    conversion.setConvert(roman.binary(number));
                    break;
                default:
                    throw new NumberFormatException("Number type is unknown.");
            }
        } catch (Exception e) {
            conversion.setConvert(e.getMessage());
        } finally {
            conversionService.saveOrUpdate(conversion);
        }
        return conversion.getConvert();
    }
    
}