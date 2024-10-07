package com.example.mapper;

import com.example.entity.Admin;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface AdminMapper {
    int insert(Admin admin); // 新增管理员

    int deleteById(Integer id); // 删除管理员

    int updateById(Admin admin); // 修改管理员信息

    Admin selectById(Integer id); // 查询特定管理员

    List<Admin> selectAll(Admin admin); // 查询所有管理员

    @Select("select * from admin where username = #{username}")
    Admin selectByUsername(String username); // 通过名字查询管理员
}