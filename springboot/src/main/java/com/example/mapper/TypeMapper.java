package com.example.mapper;

import com.example.entity.Type;
import java.util.List;

public interface TypeMapper {
    int insert(Type type); // 新增种类

    int deleteById(Integer id); // 删除种类

    int updateById(Type type); // 更新种类信息

    Type selectById(Integer id); // 查询特定种类

    List<Type> selectAll(Type type); // 查询所有种类
}
