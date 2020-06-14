package com.qf.shoppingcenter.dao;

import com.qf.shoppingcenter.entity.TGoodsInfo;
import com.qf.shoppingcenter.tool.PageTool;

import java.util.List;

public interface TGoodsInfoMapper {

    List<TGoodsInfo> findGoodsByPage(PageTool pt);

    Integer findTotalCount();

    int updateGoodsById(Integer gid);

    int updateManyGoodsByArray(int[] idsList);
}