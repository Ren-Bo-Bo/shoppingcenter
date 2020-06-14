package com.qf.shoppingcenter.dao;

import com.qf.shoppingcenter.entity.TUser;

public interface TUserMapper {
    /**
     * 根据用户属性查询用户信息
     * @param u1
     * @return TUser
     */
    TUser findUserByAttr(TUser u1);
}