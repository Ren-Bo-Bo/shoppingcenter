package com.qf.shoppingcenter.controller;

import com.qf.shoppingcenter.entity.TGoodsInfo;
import com.qf.shoppingcenter.service.TGoodsInfoService;
import com.qf.shoppingcenter.tool.PageTool;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TGoodsInfo)表控制层
 *
 * @author makejava
 * @since 2020-05-18 15:17:42
 */
@Controller
@RequestMapping("tGoodsInfo")
public class TGoodsInfoController {
    /**
     * 服务对象
     */
    @Resource
    private TGoodsInfoService tGoodsInfoService;

    /**
     * 分页查询商品信息
     * @param currpage
     * @return ModelAndView
     */
    @RequestMapping("/findGoodsByPage.action")
    public ModelAndView findGoodsByPage(@RequestParam(value="currpage",defaultValue = "1") String currpage){
        return getGoodsByPage(currpage);
    }

    /**
     * 分页查询商品信息
     * @param currpage
     * @return ModelAndView
     */
    public ModelAndView getGoodsByPage(String currpage) {
        //创建分页对象
        PageTool pt=new PageTool();
        pt.setCurrPage(Integer.valueOf(currpage));
        

        //调用业务层处理请求,并接收结果
        List<TGoodsInfo> goodsList1=tGoodsInfoService.findGoodsByPage(pt);

        //根据结果跳转页面
        ModelAndView mav=new ModelAndView("back/goods/goodsList.jsp");
        mav.addObject("goodsList",goodsList1);
        mav.addObject("page1",pt);
        return mav;
    }

    /**
     * 根据商品编号删除商品信息
     * @param gid
     * @param currpage
     * @return
     */
    @RequestMapping("/delGoodsById.action")
    public ModelAndView delGoodsById(@RequestParam("gid") String gid,@RequestParam(value="currpage",defaultValue = "1") String currpage){
        //调用业务层处理请求,并接收结果
        int result=tGoodsInfoService.delGoodsById(Integer.valueOf(gid));

        //删除成功后,查询当前页跳转到端口展示页面
        return getGoodsByPage(currpage);
    }

    /**
     * 根据商品编号删除多个商品信息
     * @param ids
     * @param currpage
     * @return
     */
    @RequestMapping("delManyGoods.action")
    public ModelAndView delManyGoods(@RequestParam("ids") String[] ids,@RequestParam(value="currpage",defaultValue = "1") String currpage){
        //调用业务层处理请求,并接收结果
        int result=tGoodsInfoService.delManyGoods(ids);

        //删除成功后,查询当前页跳转到端口展示页面
        return getGoodsByPage(currpage);
    }
}