package com.example.customer.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVo<T> {

    private List<T> list;
    private Integer totalNum;
}
