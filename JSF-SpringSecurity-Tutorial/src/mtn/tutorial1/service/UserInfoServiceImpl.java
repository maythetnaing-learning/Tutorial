package mtn.tutorial1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mtn.tutorial1.dao.UserInfoDao;
import mtn.tutorial1.dto.LoginUser;

@Service (value = "userInfoService") 
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoDao userInfoDao;
	
	@Override
	public List<LoginUser> selectAllUser() {
		return userInfoDao.selectAllUser();
	}

}