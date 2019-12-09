package com.lyzd.controlplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.lyzd.controlplatform.dao.ISUserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.lyzd.controlplatform.model.SUser;
import com.lyzd.controlplatform.service.ISUserService;

import java.util.List;

/** description：
* @author 阿劼
* @data 2019/11/26 14:53
*/
@Service
public class SUserServiceImpl implements ISUserService {

    @Resource
    private ISUserMapper userMapper;

    @Override
    public int removeByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(SUser record) {
        return userMapper.insert(record);
    }


    @Override
    public SUser queryByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public int modifyByPrimaryKey(SUser record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int queryAllCount() {
        return userMapper.selectAllSuser();
    }

    @Override
    public List<SUser> queryPage(int num, int size) {
        PageHelper.startPage(num, size);
        return userMapper.selectAll();
    }

}
