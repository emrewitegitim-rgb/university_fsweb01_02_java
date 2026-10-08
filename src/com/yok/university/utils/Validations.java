package com.yok.university.utils;

import com.yok.university.entity.Faculty;

public class Validations {
    public static void nullCheck(Object o, String message) {
        if(o == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
