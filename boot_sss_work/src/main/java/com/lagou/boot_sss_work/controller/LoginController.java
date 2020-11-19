package com.lagou.boot_sss_work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("toLogin")
    public String toLogin() {
        System.out.println("================++++++++++++++跳转登录页面");
        return "login";
    }

    @RequestMapping("loginSystem")
    public String loginSystem(HttpServletRequest request, String username, String password, HttpSession session) {
        HttpSession session1 = request.getSession();
        Object username1 = session1.getAttribute("username");
        if(username1 != null) {
            return "redirect:/resume/resumeList";

        }
        // 合法用户，信息写入session，同时跳转到系统主页面
        if("admin".equals(username) && "admin".equals(password)) {
            System.out.println("合法用户");
            session.setAttribute("username",username);
            return "redirect:/resume/resumeList";
        }
        // 非法用户返回登录页面
        System.out.println("非法，跳转");
        return "redirect:/login/toLogin";
    }
}
