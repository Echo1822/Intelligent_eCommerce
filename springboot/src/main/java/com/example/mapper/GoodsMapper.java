package com.example.mapper;

import com.example.entity.Goods;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface GoodsMapper {
    int insert(Goods goods); // 新增商品

    int deleteById(Integer id); // 删除商品

    int updateById(Goods goods); // 修改商品信息

    Goods selectById(Integer id); // 查询特定商品

    List<Goods> selectAll(Goods goods); // 查询所有商品

    // 查询特定种类商品
    @Select("select * from goods where type_id = #{id}")
    List<Goods> selectByTypeId(Integer id);

    // 查询特定商家商品
    @Select("select * from goods where business_id = #{id}")
    List<Goods> selectByBusinessId(Integer id);

    // 查询销量前15的商品
    @Select("select * from goods order by count desc limit 15")
    List<Goods> selectTop15();

    // 查询特定名字商品
    @Select("select * from goods where name like concat('%', #{name}, '%')")
    List<Goods> selectByName(String name);
}
