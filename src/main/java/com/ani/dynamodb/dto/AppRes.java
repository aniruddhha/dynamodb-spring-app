package com.ani.dynamodb.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppRes<T> {
    private T dt;
    private String msg;
    private String sts;
}
