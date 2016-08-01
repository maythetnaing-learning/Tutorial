package mtn.tutorial1.dto;

import java.io.Serializable;

public class LoginUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer roleID;
	private String userid;
	private String username;
	private String password;
	private Integer offset;
	private Integer limit;
	public Integer getRoleID() {
		return roleID;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
}
