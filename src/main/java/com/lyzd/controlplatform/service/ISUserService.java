package com.lyzd.controlplatform.service;

import com.lyzd.controlplatform.model.SUser;

import java.util.List;

/** description：
* @author 阿劼
* @data 2019/11/26 14:53
*/
public interface ISUserService {


    /**
     * 删除
     * @param id id
     * @return rows
     */
    int removeByPrimaryKey(Integer id);

    /**
     * 添加
     * @param record Suser对象
     * @return  rows
     */
    int add(SUser record);

    /**
     * 查询
     * @param id id
     * @return user对象
     */
    SUser queryByPrimaryKey(Integer id);

    /**
     * 更新
     * @param record 对象
     * @return rows
     */
    int modifyByPrimaryKey(SUser record);

    /**
     * 查询记录条数
     * @return int
     */
    int queryAllCount();

    /**
     * 分页，获取对象队列
     * @param num 页码
     * @param size 每页显示条数
     * @return 用户列表
     */
    List<SUser> queryPage(int num, int size);
    }
