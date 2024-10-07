package com.example.service;

import com.example.entity.Type;
import com.example.mapper.TypeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeService {
    @Resource
    private TypeMapper typeMapper;

    // 新增种类
    public void add(Type type) {
        typeMapper.insert(type);
    }

    // 删除种类
    public void deleteById(Integer id) {
        typeMapper.deleteById(id);
    }

    // 批量删除种类
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            typeMapper.deleteById(id);
        }
    }

    // 更新种类信息
    public void updateById(Type type) {
        typeMapper.updateById(type);
    }

    // 查询特定种类
    public Type selectById(Integer id) {
        return typeMapper.selectById(id);
    }

    // 查询所有种类
    public List<Type> selectAll(Type type) {
        return typeMapper.selectAll(type);
    }

    // 分页查询
    public PageInfo<Type> selectPage(Type type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Type> list = typeMapper.selectAll(type);
        return PageInfo.of(list);
    }
}
