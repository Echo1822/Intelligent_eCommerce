package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Account;
import com.example.entity.Notice;
import com.example.mapper.NoticeMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    // 新增公告
    public void add(Notice notice) {
        notice.setTime(DateUtil.today());
        Account currentUser = TokenUtils.getCurrentUser();
        notice.setUser(currentUser.getUsername());
        noticeMapper.insert(notice);
    }

    // 删除公告
    public void deleteById(Integer id) {
        noticeMapper.deleteById(id);
    }

    // 批量删除公告
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            noticeMapper.deleteById(id);
        }
    }

    // 更新公告信息
    public void updateById(Notice notice) {
        noticeMapper.updateById(notice);
    }

    // 查询特定公告
    public Notice selectById(Integer id) {
        return noticeMapper.selectById(id);
    }

    // 查询所有公告
    public List<Notice> selectAll(Notice notice) {
        return noticeMapper.selectAll(notice);
    }

    // 分页查询
    public PageInfo<Notice> selectPage(Notice notice, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> list = noticeMapper.selectAll(notice);
        return PageInfo.of(list);
    }
}
