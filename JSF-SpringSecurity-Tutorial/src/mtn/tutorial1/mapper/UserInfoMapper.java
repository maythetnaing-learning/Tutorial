package mtn.tutorial1.mapper;

import java.util.List;

import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.dto.StudentDisobedientDto;;

public interface UserInfoMapper {
	public List<LoginUser> getAllUser();
	public List<StudentDisobedientDto> getStudentDisobedient();
	public Integer getUserCount();
}
