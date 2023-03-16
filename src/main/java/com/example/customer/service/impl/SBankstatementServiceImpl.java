package com.example.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.customer.dto.SBankstatementDto;
import com.example.customer.entity.SBankstatement;
import com.example.customer.mapper.SBankstatementMapper;
import com.example.customer.service.ISBankstatementService;
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
public class SBankstatementServiceImpl extends ServiceImpl<SBankstatementMapper, SBankstatement> implements ISBankstatementService {
    @Autowired
    SBankstatementMapper bankstatementMapper;

    @Override
    public PageVo<SBankstatement> getBankstatement(SBankstatementDto bankstatementDto) {
        PageVo<SBankstatement> pageVo = new PageVo<>();
        bankstatementDto.setPageNum((bankstatementDto.getPageNum()-1)*bankstatementDto.getSize());
        pageVo.setList(bankstatementMapper.selectBankstatement(bankstatementDto));
        pageVo.setTotalNum(bankstatementMapper.selectTotalNum(bankstatementDto));
        return pageVo;
    }
}
