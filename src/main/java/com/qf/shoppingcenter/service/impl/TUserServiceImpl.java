package com.qf.shoppingcenter.service.impl;

import com.qf.shoppingcenter.dao.TUserMapper;
import com.qf.shoppingcenter.entity.TUser;
import com.qf.shoppingcenter.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author: REN
 * @Date: 2020/5/20 12:35
 */

@Service("tUserService")
public class TUserServiceImpl implements TUserService {
    @Resource
    private TUserMapper tUserMapper;


    /**
     * 根据用户属性查询用户信息
     * @param u1
     * @return TUser
     */
    @Override
    public TUser findUserByAttr(TUser u1) {
        return tUserMapper.findUserByAttr(u1);
    }


}
