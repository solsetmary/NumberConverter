package com.soheyl.NumberConverter.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soheyl.NumberConverter.util.INumberConverter;

@Service
public class ConvertWrapper implements IConvertWrapper {
    
    @Autowired
    INumberConverter convert;

    @Override
    public NumberWrapper convert(NumberWrapper numbers) {
        NumberWrapper numberWrapper = new NumberWrapper();
        numbers.getNumbers().stream()
        .forEach(number -> {
            numberWrapper.getNumbers()
            .add(number.setConvert(convert.toRoman(number.getNumber(), number.getType())));
        });
        return numberWrapper;
    }
    
}
