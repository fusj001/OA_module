package com.wu.oa.biz.impl;

import com.wu.oa.biz.GlobalBiz;
import com.wu.oa.dao.EmployeeDao;
import com.wu.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("globalService")
public class GlobalBizImpl implements GlobalBiz {

    @Qualifier("employeeDao")
    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if (employee != null && employee.getPassword().equals(password)){
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
