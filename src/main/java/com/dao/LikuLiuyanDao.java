package com.dao;

import com.entity.LikuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LikuLiuyanView;

/**
 * 案例库留言 Dao 接口
 *
 * @author 
 */
public interface LikuLiuyanDao extends BaseMapper<LikuLiuyanEntity> {

   List<LikuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
