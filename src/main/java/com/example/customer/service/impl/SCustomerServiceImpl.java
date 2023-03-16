package com.example.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.customer.dto.SCustomerDto;
import com.example.customer.entity.SCustomer;
import com.example.customer.mapper.SCustomerMapper;
import com.example.customer.service.ISCustomerService;
import com.example.customer.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junjie
 * @since 2023-03-16
 */
@Service
public class SCustomerServiceImpl extends ServiceImpl<SCustomerMapper, SCustomer> implements ISCustomerService {
    @Autowired
    SCustomerMapper customerMapper;
    @Override
    public PageVo<SCustomer> getCustomer(SCustomerDto customerDto) {
        PageVo<SCustomer> pageVo = new PageVo<>();
        customerDto.setName("+"+customerDto.getName()+"*");
        customerDto.setPageNum((customerDto.getPageNum()-1)*customerDto.getSize());
        pageVo.setList(customerMapper.selectCustomer(customerDto));
        pageVo.setTotalNum(customerMapper.selectTotalNum(customerDto));
        return pageVo;
    }

    @Override
    public PageVo<SCustomer> getCustomerByParentId(SCustomerDto customerDto) {
        PageVo<SCustomer> pageVo = new PageVo<>();
        customerDto.setPageNum((customerDto.getPageNum()-1)*customerDto.getSize());
        pageVo.setList(customerMapper.selectCustomerRel(customerDto));
        pageVo.setTotalNum(customerMapper.selectRelTotalNum(customerDto));
        return pageVo;
    }


}
