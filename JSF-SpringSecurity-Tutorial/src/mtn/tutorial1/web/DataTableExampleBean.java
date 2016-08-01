package mtn.tutorial1.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.dto.StudentDisobedientDto;
import mtn.tutorial1.service.UserInfoService;

@ViewScoped
@ManagedBean (name = "dataTableExampleBean")
public class DataTableExampleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	List<LoginUser> userList;
	List<StudentDisobedientDto> existingStdDisobedientDtoList;
	List<StudentDisobedientDto> newStdDisobedientDtoList;
	
	protected Map<String, Object> dialogOptions;
	
	boolean showFlg;
	int rowSpanSize;
	
	@ManagedProperty(value = "#{userInfoService}")
	private UserInfoService userInfoService;
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@PostConstruct
	public void onLoad(){
		newStdDisobedientDtoList = new ArrayList<StudentDisobedientDto>();
		userList = userInfoService.selectAllUser();
		existingStdDisobedientDtoList = userInfoService.selectStudentDisobedient(); 
	}
	
	public boolean displayRow(int rowIndex, String studentRollNo){
		rowSpanSize = 0;
		if (existingStdDisobedientDtoList != null){
			if (rowIndex == 0){ 
				showFlg = true;
				getRowSpan(studentRollNo);
			} 
			else {
				if (existingStdDisobedientDtoList.get(rowIndex-1).getStudentRollNo().equals(studentRollNo) ){
					showFlg = false;			
				} else {
					showFlg = true;
					getRowSpan(studentRollNo);
				}
			}
		}
		return showFlg;
	}

	public void getRowSpan(String studentRollNo){
		for (StudentDisobedientDto studentDisobedientDto : existingStdDisobedientDtoList) {
			if (studentDisobedientDto.getStudentRollNo().equals(studentRollNo)){
				rowSpanSize++;
			}
		}
	}

	public void viewUserPopup() {
		RequestContext.getCurrentInstance().openDialog("userPopup", getDialogOption(), null);
	}

	public void onStudentSelect(SelectEvent event) {
		List<LoginUser> resultList = (List<LoginUser>) event.getObject();
		for(LoginUser user : resultList){ 
			StudentDisobedientDto studentDisobedientDto = new StudentDisobedientDto();
			studentDisobedientDto.setFirstName(user.getUsername());
			newStdDisobedientDtoList.add(studentDisobedientDto);
		}
	}
	
	protected Map<String, Object> getDialogOption() {
		dialogOptions = new HashMap<String, Object>();
		dialogOptions.put("modal", true);
		dialogOptions.put("draggable", false);
		dialogOptions.put("resizable", false);
		dialogOptions.put("contentHeight", 600);
		dialogOptions.put("contentWidth", 900);
		return dialogOptions;
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
		return existingStdDisobedientDtoList;
	}

	public void setStudentDisobedientDtoList(
			List<StudentDisobedientDto> studentDisobedientDtoList) {
		this.existingStdDisobedientDtoList = studentDisobedientDtoList;
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

	public List<StudentDisobedientDto> getExistingStdDisobedientDtoList() {
		return existingStdDisobedientDtoList;
	}

	public void setExistingStdDisobedientDtoList(
			List<StudentDisobedientDto> existingStdDisobedientDtoList) {
		this.existingStdDisobedientDtoList = existingStdDisobedientDtoList;
	}

	public List<StudentDisobedientDto> getNewStdDisobedientDtoList() {
		return newStdDisobedientDtoList;
	}

	public void setNewStdDisobedientDtoList(
			List<StudentDisobedientDto> newStdDisobedientDtoList) {
		this.newStdDisobedientDtoList = newStdDisobedientDtoList;
	}

}
