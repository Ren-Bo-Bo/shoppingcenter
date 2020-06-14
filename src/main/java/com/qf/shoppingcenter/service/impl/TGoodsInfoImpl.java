package com.qf.shoppingcenter.service.impl;

import com.qf.shoppingcenter.dao.TGoodsInfoMapper;
import com.qf.shoppingcenter.entity.TGoodsInfo;
import com.qf.shoppingcenter.service.TGoodsInfoService;
import com.qf.shoppingcenter.tool.PageTool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @Author: REN
 * @Date: 2020/5/20 15:20
 */
@Service
public class TGoodsInfoImpl implements TGoodsInfoService {
    @Resource
    private TGoodsInfoMapper tGoodsInfoMapper;

    @Override
    public List<TGoodsInfo> findGoodsByPage(PageTool pt) {
        //初始化分页工具类
        pt.setPageCount(5);
        pt.setStart((pt.getCurrPage()-1)*pt.getPageCount());
        pt.setTotalCount(tGoodsInfoMapper.findTotalCount());
        if (pt.getTotalCount()%pt.getPageCount()==0){
            pt.setTotalPage(pt.getTotalCount()/pt.getPageCount());
        }else{
            pt.setTotalPage(pt.getTotalCount()/pt.getPageCount()+1);
        }
        return tGoodsInfoMapper.findGoodsByPage(pt);
    }

    /**
     * 根据商品编号删除商品信息
     * @param gid
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int delGoodsById(Integer gid) {
        //根据商品编号删除商品信息,在数据库表中不是真删除,只是修改商品无效
        return tGoodsInfoMapper.updateGoodsById(gid);
    }

    /**
     * 根据商品编号删除多个商品信息
     * @param ids
     * @return int
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int delManyGoods(String[] ids) {
//        //第一种:遍历商品编号数组,利用dao层,一个一个删除端口
//        //声明一个变量作记数器,记数删除的商品个数
//        int count = 0;
//        //遍历商品编号数组,根据商品编号一个一个删除端口信息(假删除,实际上是修改商品有效性)
//        for (int i = 0; i < ids.length; i++) {
//            tGoodsInfoMapper.updateGoodsById(Integer.valueOf(ids[i]));
//            count++;
//        }
//        return count;

        //第二种:将要删除端口编号数组传到Dao,在dao层根据数组删除
        int[] idsList=new int[ids.length];
        for (int i=0;i<ids.length;i++){
            idsList[i]=Integer.valueOf(ids[i]);
        }
        return tGoodsInfoMapper.updateManyGoodsByArray(idsList);
    }
}

