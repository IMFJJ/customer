package com.example.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.customer.dto.SCustomerDto;
import com.example.customer.entity.SCustomer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junjie
 * @since 2023-03-16
 */
@Component
public interface SCustomerMapper extends BaseMapper<SCustomer> {
    List<SCustomer> selectCustomer(SCustomerDto sCustomerDto);
    int selectTotalNum(SCustomerDto sCustomerDto);
    List<SCustomer> selectCustomerRel(SCustomerDto sCustomerDto);
    int selectRelTotalNum(SCustomerDto sCustomerDto);
}
