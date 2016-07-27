package mtn.tutorial1.service;

import java.util.List;

import mtn.tutorial1.dto.LoginUser;

public interface UserInfoService {
	public List<LoginUser> selectAllUser();
}
