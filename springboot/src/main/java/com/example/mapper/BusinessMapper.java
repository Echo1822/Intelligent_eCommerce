package com.example.mapper;

import com.example.entity.Business;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface BusinessMapper {
    int insert(Business business); // 新增商家

    int deleteById(Integer id); // 删除商家

    int updateById(Business business); // 修改商家信息

    Business selectById(Integer id); // 查询特定商家

    List<Business> selectAll(Business business); // 查询所有商家

    @Select("select * from business where username = #{username}")
    Business selectByUsername(String username); // 通过名字查询商家
}
