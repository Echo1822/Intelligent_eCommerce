package com.example.mapper;

import com.example.entity.Orders;
import java.util.List;

public interface OrdersMapper {
    int insert(Orders orders); // 新增订单

    int deleteById(Integer id); // 删除订单

    int updateById(Orders orders); // 更新订单信息

    Orders selectById(Integer id); // 查询特定订单

    List<Orders> selectAll(Orders orders); // 查询所有订单

    List<Orders> selectAllOKOrders();
}