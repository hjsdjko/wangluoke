package com.dao;

import com.entity.JiaoanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoanView;

/**
 * 教案 Dao 接口
 *
 * @author 
 */
public interface JiaoanDao extends BaseMapper<JiaoanEntity> {

   List<JiaoanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
