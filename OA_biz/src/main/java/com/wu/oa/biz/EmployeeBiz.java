package com.wu.oa.biz;

import com.wu.oa.entity.Employee;

import java.util.List;

/**
 * 雇员业务接口
 */
public interface EmployeeBiz {
    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}
