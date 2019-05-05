package com.wu.oa.controller;

import com.wu.oa.biz.GlobalBiz;
import com.wu.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("globalController")
public class GloablController {

    @Autowired
    private GlobalBiz globalBiz;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam("sn") String sn, @RequestParam("password") String password){
        Employee employee = globalBiz.login(sn,password);
        if (employee == null) return "redirect:to_login";
        session.setAttribute("employee",employee);
        return "redirect:self";
    }

    @RequestMapping("/self")
    public String self(){
        return "self";
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    @RequestMapping("/change_password")
    public String changePassword(HttpSession session,@RequestParam("old") String old,
                                 @RequestParam("new1")String new1,@RequestParam("new2")String new2){
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee.getPassword().equals(old) && new1.equals(new2)){
            employee.setPassword(new1);
            globalBiz.changePassword(employee);
            return "redirect:self";
        }
        return "redirect:to_change_password";
    }
}
