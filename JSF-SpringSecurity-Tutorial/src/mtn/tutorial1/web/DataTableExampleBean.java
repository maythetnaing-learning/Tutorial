package mtn.tutorial1.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.dto.StudentDisobedientDto;
import mtn.tutorial1.service.UserInfoService;

@ViewScoped
@ManagedBean (name = "dataTableExampleBean")
public class DataTableExampleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	List<LoginUser> userList;
	List<StudentDisobedientDto> studentDisobedientDtoList;
	boolean showFlg;
	int rowSpanSize;
	
	@ManagedProperty(value = "#{userInfoService}")
	private UserInfoService userInfoService;
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@PostConstruct
	public void onLoad(){
		userList = userInfoService.selectAllUser();
		studentDisobedientDtoList = userInfoService.selectStudentDisobedient(); 
	}
	
	public boolean displayRow(int rowIndex, String studentRollNo){
		rowSpanSize = 0;
		getRowSpan(studentRollNo);
		if (studentDisobedientDtoList != null){
			if (rowIndex == 0){ 
				showFlg = true;
			} 
			else {
				if (studentDisobedientDtoList.get(rowIndex-1).getStudentRollNo().equals(studentRollNo) ){
					showFlg = false;			
				} else {
					showFlg = true;
				}
			}
		}
		return showFlg;
	}

	public void getRowSpan(String studentRollNo){
		for (StudentDisobedientDto studentDisobedientDto : studentDisobedientDtoList) {
			if (studentDisobedientDto.getStudentRollNo().equals(studentRollNo)){
				rowSpanSize++;
			}
		}
	}
	
	public boolean displayRow(){
		return true;
	}

	public void doDelete(){
		// Process delete.
	}

	public List<LoginUser> getUserList() {
		return userList;
	}

	public void setUserList(List<LoginUser> userList) {
		this.userList = userList;
	}

	
	public List<StudentDisobedientDto> getStudentDisobedientDtoList() {
		return studentDisobedientDtoList;
	}

	public void setStudentDisobedientDtoList(
			List<StudentDisobedientDto> studentDisobedientDtoList) {
		this.studentDisobedientDtoList = studentDisobedientDtoList;
	}

	public boolean isShowFlg() {
		return showFlg;
	}

	public void setShowFlg(boolean showFlg) {
		this.showFlg = showFlg;
	}

	public int getRowSpanSize() {
		return rowSpanSize;
	}

	public void setRowSpanSize(int rowSpanSize) {
		this.rowSpanSize = rowSpanSize;
	}

}
