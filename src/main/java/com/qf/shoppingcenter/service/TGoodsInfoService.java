package com.qf.shoppingcenter.service;

import com.qf.shoppingcenter.dto.TGoodsTypeDto;
import com.qf.shoppingcenter.entity.TGoodsInfo;
import com.qf.shoppingcenter.tool.PageTool;

import java.util.List;

/**
 * @version 1.0
 * @Author: REN
 * @Date: 2020/5/20 15:20
 */

public interface TGoodsInfoService {
    List<TGoodsInfo> findGoodsByPage(PageTool pt);

    /**
     * 根据商品编号删除商品信息
     * @param gid
     * @return int
     */
    int delGoodsById(Integer gid);

    int delManyGoods(String[] ids);

}
