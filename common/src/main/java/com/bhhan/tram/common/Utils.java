package com.bhhan.tram.common;

import java.util.UUID;

/**
 * Created by hbh5274@gmail.com on 2020-11-03
 * Github : http://github.com/bhhan5274
 */
public class Utils {
    public static String generateUniqueString(){
        return UUID.randomUUID().toString();
    }
}
