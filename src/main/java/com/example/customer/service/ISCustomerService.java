package com.example.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.customer.dto.SCustomerDto;
import com.example.customer.entity.SCustomer;
import com.example.customer.vo.PageVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junjie
 * @since 2023-03-16
 */
public interface ISCustomerService extends IService<SCustomer> {

    /**
    * @Description: 根据客户名称全文索引
    * @author FJJ
    */
    PageVo<SCustomer> getCustomer(SCustomerDto sCustomerDto);

    /**
    * @Description: 根据客户id作为父类id查询
    * @author FJJ
    */
    PageVo<SCustomer> getCustomerByParentId(SCustomerDto sCustomerDto);
}
