package com.example.mapper;

import com.example.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface CartMapper {
    int insert(Cart cart); // 购物车新增商品

    int deleteById(Integer id); // 购物车删除商品

    int updateById(Cart cart); // 购物车修改商品信息

    Cart selectById(Integer id); // 查询购物车特定商品

    List<Cart> selectAll(Cart cart); // 查询购物车所有商品

    // 查询特定用户对特定商品的加入与否
    @Select("select * from cart where user_id = #{userId} and goods_id = #{goodsId}")
    Cart selectByUserIdAndGoodsId(@Param("userId") Integer userId, @Param("goodsId") Integer goodsId);
}