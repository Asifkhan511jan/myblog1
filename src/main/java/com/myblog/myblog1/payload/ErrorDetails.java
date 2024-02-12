package com.myblog.myblog1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private  String message;

    private Date date;

    private String url;
}
