package com.example.mapper;

import com.example.entity.Notice;
import java.util.List;

public interface NoticeMapper {
    int insert(Notice notice); // 新增公告

    int deleteById(Integer id); // 删除公告

    int updateById(Notice notice); // 更新公告信息

    Notice selectById(Integer id); // 查询特定公告

    List<Notice> selectAll(Notice notice); // 查询所有公告
}
