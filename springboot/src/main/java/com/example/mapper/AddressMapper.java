package com.example.mapper;

import com.example.entity.Address;
import java.util.List;

public interface AddressMapper {
    int insert(Address address); // 新增地址

    int deleteById(Integer id); // 删除地址

    int updateById(Address address); // 修改地址

    Address selectById(Integer id); // 查询特定地址

    List<Address> selectAll(Address address); // 查询所有地址
}
