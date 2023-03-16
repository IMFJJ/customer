package com.example.customer.dto;

import lombok.Data;

@Data
public class PageDto {
    Integer size = 10;
    Integer pageNum = 1;
}
