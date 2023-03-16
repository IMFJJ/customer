package com.example.customer.controller;


import com.example.customer.dto.SCustomerDto;
import com.example.customer.service.ISCustomerService;
import com.example.customer.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author junjie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/customer")
public class SCustomerController {
    @Autowired
    ISCustomerService customerService;

    @GetMapping("/get")
    public RespResult get(SCustomerDto customerDto) {
        try {
            if (!StringUtils.hasText(customerDto.getName())) {
                return RespResult.error("客户名称不能为空!");
            }
            return RespResult.ok(customerService.getCustomer(customerDto));
        } catch (Exception e) {
            e.printStackTrace();
            return RespResult.error(e.getMessage());
        }
    }

    @GetMapping("/getByParentId")
    public RespResult getByParentId(SCustomerDto customerDto) {
        try {
            if (customerDto.getParentId() == null) {
                return RespResult.error("父类客户id不能为空!");
            }
            return RespResult.ok(customerService.getCustomerByParentId(customerDto));
        } catch (Exception e) {
            e.printStackTrace();
            return RespResult.error(e.getMessage());
        }
    }
}
