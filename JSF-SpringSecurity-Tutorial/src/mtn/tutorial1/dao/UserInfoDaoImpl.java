package mtn.tutorial1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.dto.StudentDisobedientDto;
import mtn.tutorial1.mapper.UserInfoMapper;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<LoginUser> selectAllUser() {
		return userInfoMapper.getAllUser();
	}

	@Override
	public List<StudentDisobedientDto> getStudentDisobedient() { 
		return userInfoMapper.getStudentDisobedient();
	}

	@Override
	public Integer getUserCount() { 
		return userInfoMapper.getUserCount();
	}

}
