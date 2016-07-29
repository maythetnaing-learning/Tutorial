package mtn.tutorial1.service;

import java.util.List;

import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.dto.StudentDisobedientDto;

public interface UserInfoService {
	public List<LoginUser> selectAllUser();
	public List<StudentDisobedientDto> selectStudentDisobedient();
}
