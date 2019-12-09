package com.lyzd.controlplatform.dao;

import com.lyzd.controlplatform.model.SUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/** description：
* @author 阿劼
* @data 2019/11/26 14:53
*/
@Mapper
public interface ISUserMapper {

    /**
     * 删除
     * @param id id
     * @return rows
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record Suser对象
     * @return rows
     */
    int insert(SUser record);

    /**
     * 查询
     * @param id ID
     * @return Suser对象
     */
    SUser selectByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record 对象
     * @return rows
     */
    int updateByPrimaryKey(SUser record);

    /**
     * 查询数据条数
     * @return  int
     */
    int selectAllSuser();

    /**
     * 查询所有
     * @return SUser对象列表
     */
    List<SUser> selectAll();
}