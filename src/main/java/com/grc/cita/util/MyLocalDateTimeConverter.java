package com.grc.cita.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MyLocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(java.time.LocalDateTime attribute){
        return attribute == null ? null : java.sql.Timestamp.valueOf(attribute);
    }
    @Override
    public java.time.LocalDateTime convertToEntityAttribute(java.sql.Timestamp dbData){
        return dbData == null ? null : dbData.toLocalDateTime();
    }


}
