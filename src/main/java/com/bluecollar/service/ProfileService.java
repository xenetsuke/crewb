package com.bluecollar.service;

import com.bluecollar.dto.ProfileDTO;
import com.bluecollar.exception.BlueCollarException;

public interface ProfileService {
	
   public Long createProfile(String email) throws BlueCollarException;
   
	public ProfileDTO getProfile(Long id) throws BlueCollarException;
	public ProfileDTO updateProfile(ProfileDTO profileDTO) throws BlueCollarException;
	

}
