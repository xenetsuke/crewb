package com.bluecollar.service;

import java.util.List;

import com.bluecollar.dto.JobDTO;
import com.bluecollar.exception.BlueCollarException;

public interface JobService {

	public JobDTO postJob(JobDTO jobDTO) throws BlueCollarException;

	public List<JobDTO> getAllJobs();
	
	public JobDTO getJob(Long id) throws BlueCollarException;

}
