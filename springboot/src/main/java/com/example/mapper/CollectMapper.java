package com.example.mapper;

import com.example.entity.Collect;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface CollectMapper {
    int insert(Collect collect); // 收藏新增商品

    int deleteById(Integer id); // 收藏删除商品

    int updateById(Collect collect); // 收藏更新商品信息

    Collect selectById(Integer id); // 查询收藏特定商品

    List<Collect> selectAll(Collect collect); // 查询收藏所有商品

    // 判断特定用户特定商品收藏与否
    @Select("select * from collect where user_id = #{userId} and goods_id = #{goodsId}")
    Collect selectByUserIdAndGoodsId(@Param("userId") Integer userId, @Param("goodsId") Integer goodsId);
}