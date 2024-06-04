package com.ex.vigo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.ex.vigo.entities.UserProfile;
import com.ex.vigo.model.LoginModel;
import com.ex.vigo.repo.UserProfileRepository;

@Service
public class LoginService {

	@Autowired
	private UserProfileRepository userProfileRepository;
	
	public LoginModel authenticate(LoginModel loginModel) {
		try {
			Optional<UserProfile> userProfile = userProfileRepository.findById(loginModel.getUserId());
			if(userProfile.isEmpty()) {
				loginModel.setResponse("User Id doesn't Exist");
			} else if (userProfile.get().getPassword().equals(DigestUtils.md5DigestAsHex(loginModel.getPassword().getBytes()))) {
				UserProfile  obj = userProfile.get();
				loginModel.setResponse("OK");
				loginModel.setRegistrationNumber(obj.getRegistrationNumber());
				loginModel.setUserName(obj.getUserName());
			} else {
				loginModel.setResponse("Incorrect Password");
			}
			loginModel.setUserId(null);
			loginModel.setPassword(null);
		} catch(Exception e) {
			e.printStackTrace();
			loginModel.setUserId(null);
			loginModel.setPassword(null);
			loginModel.setResponse("Something went wrong!");
		}
		return loginModel;
	}

}
