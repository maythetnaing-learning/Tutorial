package mtn.tutorial1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mtn.tutorial1.dao.UserInfoDao;
import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.dto.LoginUserPagingData;
import mtn.tutorial1.dto.StudentDisobedientDto;

@Service (value = "userInfoService") 
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoDao userInfoDao;
	
	@Override
	public List<LoginUser> selectAllUser() {
		return userInfoDao.selectAllUser();
	}
	
	@Override
	public List<StudentDisobedientDto> selectStudentDisobedient() {
		return userInfoDao.getStudentDisobedient();
	}

	@Override
	public LoginUserPagingData selectAllUserByPaging(LoginUser loginUser) {
		List<LoginUser> resultList = new ArrayList<LoginUser>();
		int count = userInfoDao.getUserCount();
		resultList = userInfoDao.selectAllUser();
		LoginUserPagingData result = new LoginUserPagingData(resultList, count);
		return result;
	}

}
