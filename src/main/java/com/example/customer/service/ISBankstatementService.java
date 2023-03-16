package com.example.customer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.customer.dto.SBankstatementDto;
import com.example.customer.entity.SBankstatement;
import com.example.customer.vo.PageVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junjie
 * @since 2023-03-16
 */
public interface ISBankstatementService extends IService<SBankstatement> {
    PageVo<SBankstatement> getBankstatement(SBankstatementDto bankstatementDto);
}
