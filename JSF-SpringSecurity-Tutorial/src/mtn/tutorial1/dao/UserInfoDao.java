package mtn.tutorial1.dao;

import java.util.List;

import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.dto.StudentDisobedientDto;

public interface UserInfoDao {
	public List<LoginUser> selectAllUser();
	public List<StudentDisobedientDto> getStudentDisobedient();

}
