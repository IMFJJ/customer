package com.example.customer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author junjie
 * @since 2023-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SBankstatement {

    /**
     * 流水号
     */
    private Integer id;
    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 交易日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 付款人
     */
    private String name;


}
