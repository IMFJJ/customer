package com.example.customer.dto;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author junjie
 * @since 2023-03-16
 */
@Data
public class SCustomerDto extends PageDto {
    /**
     * 客户号
     */
    private Integer id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户名称
     */
    private Integer parentId;
}
