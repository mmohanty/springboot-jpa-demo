package com.manas.springboot.demo.jpa.service.util;

import java.util.Date;

public class TimeDelayUtil {



    public static void delay() {
        long start = new Date().getTime();
        while(new Date().getTime() - start < 1000L){}
    }
}
