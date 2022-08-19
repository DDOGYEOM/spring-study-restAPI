package com.openobject.restapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDTO {
	
	@JsonProperty("user_id")
	private String userId;	
	private String password;
	private boolean useCookie;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private boolean isUseCookie() {
		return useCookie;
	}
	
	private void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	

}
