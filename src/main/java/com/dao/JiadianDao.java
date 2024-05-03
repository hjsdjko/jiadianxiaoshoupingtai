package com.dao;

import com.entity.JiadianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiadianView;

/**
 * 商品 Dao 接口
 *
 * @author 
 */
public interface JiadianDao extends BaseMapper<JiadianEntity> {

   List<JiadianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
