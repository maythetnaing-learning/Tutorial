package mtn.tutorial1.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mtn.tutorial1.dto.LoginUser;
import mtn.tutorial1.service.UserInfoService;

@ViewScoped
@ManagedBean (name = "dataTableExampleBean")
public class DataTableExampleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	List<LoginUser> userList;
	
	@ManagedProperty(value = "#{userInfoService}")
	private UserInfoService userInfoService;
	
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@PostConstruct
	public void onLoad(){
		userList = userInfoService.selectAllUser();
	}

	public void doDelete(){
		userList = userInfoService.selectAllUser();
	}

	public List<LoginUser> getUserList() {
		return userList;
	}

	public void setUserList(List<LoginUser> userList) {
		this.userList = userList;
	}
}
