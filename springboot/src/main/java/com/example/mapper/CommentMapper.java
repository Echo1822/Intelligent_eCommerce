package com.example.mapper;

import com.example.entity.Comment;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface CommentMapper {
    int insert(Comment comment); // 新增评论

    int deleteById(Integer id); // 删除评论

    int updateById(Comment comment); // 更新评论信息

    Comment selectById(Integer id); // 查询特定评论

    List<Comment> selectAll(Comment comment); // 查询所有评论

    // 查询特定商品评论
    @Select("select comment.*, user.avatar as userAvatar, user.name as userName from comment left join user on comment.user_id = user.id where comment.goods_id = #{id}")
    List<Comment> selectByGoodsId(Integer id);
}
