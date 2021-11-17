package com.example.notesStorage.registration;

import com.example.notesStorage.BaseEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ValidationFactory {

    private final static Map<String, ValidatorI> VALIDATOR = new ConcurrentHashMap<>();

    public synchronized static <T extends BaseEntity<ID>, R extends ValidatorI<T, ID>, ID> ValidatorImpl<T, ID> of(Class<T> modelClass) {
        System.out.println("ControllerFactory");
        final String modelName = modelClass.getName();
        if (!VALIDATOR.containsKey(modelName)) {
            VALIDATOR.put(modelName, new ValidatorImpl<>(modelClass));
        }
        return (ValidatorImpl<T, ID>) VALIDATOR.get(modelName);
    }

}