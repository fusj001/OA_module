package com.wu.oa.biz;

import com.wu.oa.entity.Department;

import java.util.List;

/**
 * 部门业务接口
 */
public interface DepartmentBiz {
    void add(Department department);
    void edit(Department department);
    void reomove(String sn);
    Department get(String sn);
    List<Department> getAll();
}
