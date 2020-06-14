package com.qf.shoppingcenter.dao;

import com.qf.shoppingcenter.dto.TGoodsTypeDto;

import java.util.List;

public interface TGoodsTypeMapper {

    List<TGoodsTypeDto> findParentAndChild();
}