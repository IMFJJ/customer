package com.example.customer.dto;

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
public class SBankstatementDto extends PageDto {

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 交易日期
     */
    private LocalDateTime createTime;

    /**
     * 付款人
     */
    private String name;


}
