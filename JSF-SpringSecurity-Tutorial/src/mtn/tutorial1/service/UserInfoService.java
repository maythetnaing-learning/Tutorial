package mtn.tutorial1.service;

import java.util.List;

import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.dto.LoginUserPagingData;
import mtn.tutorial1.dto.StudentDisobedientDto;

public interface UserInfoService {
	public List<LoginUser> selectAllUser();
	public LoginUserPagingData selectAllUserByPaging(LoginUser loginUser);
	public List<StudentDisobedientDto> selectStudentDisobedient();
}
