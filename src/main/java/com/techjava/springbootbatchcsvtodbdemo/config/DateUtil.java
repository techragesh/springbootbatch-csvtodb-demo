package com.techjava.springbootbatchcsvtodbdemo.config;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Component
public class DateUtil {

    @Bean
    public Map<? extends Object, ? extends PropertyEditor> customEditors(){
        Map<Object, PropertyEditor> customEditors = new HashMap<Object, PropertyEditor>();
        customEditors.put("java.util.Date", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true){

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if("NULL".equalsIgnoreCase(text)){
                    text = "";
                }
                super.setAsText(text);
            }

        });
        customEditors.put("java.lang.Integer", new CustomNumberEditor(Integer.class, true){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if("NULL".equalsIgnoreCase(text)){
                    text = "";
                }
                super.setAsText(text);
            }
        });
        return customEditors;
    }
}
