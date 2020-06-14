package com.qf.shoppingcenter.controller;


import com.qf.shoppingcenter.entity.TUser;
import com.qf.shoppingcenter.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;


/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-05-18 15:17:42
 */
@SessionAttributes(value = {"user1"})
@Controller
@RequestMapping("/tUser")
public class TUserController {
    /**
     * 服务对象
     */
    @Autowired
    private TUserService tUserService;

    @RequestMapping("/login.action")
    public ModelAndView login(@RequestParam(value="remember",defaultValue ="null") String remember,
                              @RequestParam("isAdmin") String isAdmin,
                              @RequestParam("name") String name,
                              @RequestParam("password") String password
    ) throws UnsupportedEncodingException {
        //将请求中数据封装成对象
        TUser u1=new TUser();
        u1.setIsAdmin(Boolean.valueOf(isAdmin));
        u1.setName(name);
        u1.setPassword(password);

        //调用业务层处理请求并接收结果
        TUser tUser=tUserService.findUserByAttr(u1);

        //声明ModelAndView对象
        ModelAndView mav;
        //根据身份及结果判断跳转页面
        if (u1.getIsAdmin()==true){//管理员
            if (tUser==null){//登录失败
                mav=new ModelAndView("backLogin.jsp");
                mav.addObject("mess","用户名或密码有误,登录失败");
            }else{//登录成功
                mav=new ModelAndView("back/main.jsp");
                mav.addObject("user1",tUser);
            }
        }else{//普通用户
            if (tUser==null){//登录失败
                mav=new ModelAndView("login.jsp");
                mav.addObject("mess","用户名或密码有误,登录失败");
            }else{//登录成功
                //记住我
                mav=new ModelAndView("index.jsp");
                mav.addObject("user1",tUser);
            }
        }
        return mav;
    }


}