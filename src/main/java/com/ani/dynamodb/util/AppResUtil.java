package com.ani.dynamodb.util;

import com.ani.dynamodb.dto.AppRes;

public class AppResUtil {
    public static <T> AppRes<T> buildResponse(T t, String msg, String sts) {
        return AppRes.<T>builder()
                .msg(msg)
                .sts(sts)
                .build();
    }
}
