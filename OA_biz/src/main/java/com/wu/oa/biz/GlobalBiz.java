package com.wu.oa.biz;

import com.wu.oa.entity.Employee;

/**
 * 登陆与个人信息接口
 */
public interface GlobalBiz {
    Employee login(String sn,String password);
    void changePassword(Employee employee);
}
