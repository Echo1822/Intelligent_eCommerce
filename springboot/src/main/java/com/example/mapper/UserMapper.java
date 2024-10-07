package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface UserMapper {
    int insert(User user); // 新增用户

    int deleteById(Integer id); // 删除用户

    int updateById(User user); // 更新用户信息

    User selectById(Integer id); // 查询特定用户

    List<User> selectAll(User user); // 查询所有用户

    // 查询特定名字用户
    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);
}
