package com.example.customer.controller;


import com.example.customer.dto.SBankstatementDto;
import com.example.customer.service.ISBankstatementService;
import com.example.customer.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author junjie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/bankstatement")
public class SBankstatementController {

    @Autowired
    ISBankstatementService bankstatementService;
    @GetMapping("/get")
    public RespResult get(SBankstatementDto bankstatementDto) {
        try {
            if (!StringUtils.hasText(bankstatementDto.getName())) {
                return RespResult.error("客户名称不能为空!");
            }
            return RespResult.ok(bankstatementService.getBankstatement(bankstatementDto));
        } catch (Exception e) {
            e.printStackTrace();
            return RespResult.error(e.getMessage());
        }
    }

}
