package com.qf.shoppingcenter.service;

import com.qf.shoppingcenter.entity.TUser;

/**
 * @version 1.0
 * @Author: REN
 * @Date: 2020/5/20 12:35
 */
public interface TUserService {


    /**
     * 根据用户属性查询用户信息
     * @param u1
     * @return TUser
     */
    TUser findUserByAttr(TUser u1);
}
