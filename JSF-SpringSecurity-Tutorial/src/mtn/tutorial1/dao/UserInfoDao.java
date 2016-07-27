package mtn.tutorial1.dao;

import java.util.List;

import mtn.tutorial1.dto.LoginUser;

public interface UserInfoDao {
	public List<LoginUser> selectAllUser();
}
