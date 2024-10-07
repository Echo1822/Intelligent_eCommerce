package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Collect;
import com.example.exception.CustomException;
import com.example.mapper.CollectMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectService {
    @Resource
    private CollectMapper collectMapper;

    // 收藏新增商品
    public void add(Collect collect) {
        // 判断一下该用户有没有收藏过该商品，如果有，就要提示用户不能重复收藏
        Collect dbCollect = collectMapper.selectByUserIdAndGoodsId(collect.getUserId(), collect.getGoodsId());
        if (ObjectUtil.isNotEmpty(dbCollect)) {
            throw new CustomException(ResultCodeEnum.COLLECT_ALREADY_ERROR);
        }
        collectMapper.insert(collect);
    }

    // 收藏删除商品
    public void deleteById(Integer id) {
        collectMapper.deleteById(id);
    }

    // 收藏批量删除商品
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            collectMapper.deleteById(id);
        }
    }

    // 收藏更新商品信息
    public void updateById(Collect collect) {
        collectMapper.updateById(collect);
    }

    // 查询收藏特定商品
    public Collect selectById(Integer id) {
        return collectMapper.selectById(id);
    }

    // 查询收藏所有商品
    public List<Collect> selectAll(Collect collect) {
        return collectMapper.selectAll(collect);
    }

    // 分页查询
    public PageInfo<Collect> selectPage(Collect collect, Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())) {
            collect.setUserId(currentUser.getId());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Collect> list = collectMapper.selectAll(collect);
        return PageInfo.of(list);
    }
}
