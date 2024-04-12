package com.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserLogin {
	
	@Id
	private String uname;
	private String pwd;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public UserLogin(String uname, String pwd) {
		super();
		this.uname = uname;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "UserLogin [uname=" + uname + ", pwd=" + pwd + "]";
	}
	public UserLogin() {
		// TODO Auto-generated constructor stub
	}

}
