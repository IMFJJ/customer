package com.example.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.customer.dto.SBankstatementDto;
import com.example.customer.entity.SBankstatement;
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
public interface SBankstatementMapper extends BaseMapper<SBankstatement> {
    List<SBankstatement> selectBankstatement(SBankstatementDto bankstatementDto);
    int selectTotalNum(SBankstatementDto bankstatementDto);
}
