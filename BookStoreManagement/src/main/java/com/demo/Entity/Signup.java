package com.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Signup {
	
	@Id
	private String uname;
	private String rpwd;
	private String pwd;

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRpwd() {
		return rpwd;
	}
	public void setRpwd(String rpwd) {
		this.rpwd = rpwd;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Signup [ uname=" + uname + ", rpwd=" + rpwd + ", pwd=" + pwd + "]";
	}
	public Signup( String uname, String rpwd, String pwd) {
		super();
	
		this.uname = uname;
		this.rpwd = rpwd;
		this.pwd = pwd;
	}
	
	public Signup() {
		// TODO Auto-generated constructor stub
	}
}
