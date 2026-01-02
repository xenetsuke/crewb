package com.bluecollar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluecollar.dto.JobDTO;
import com.bluecollar.exception.BlueCollarException;
import com.bluecollar.repository.JobRepository;
import com.bluecollar.utility.Utilities;

@Service("jobService")
public class JobServiceImpl implements JobService {
	
	@Autowired
    private JobRepository jobRepository ;

	@Override
	public JobDTO postJob(JobDTO jobDTO) throws BlueCollarException {
	
		jobDTO.setId(Utilities.getNextSequenceId("jobs"));
		return jobRepository.save(jobDTO.toEntity()).toDTO() ;
		
	}

	@Override
	public List<JobDTO> getAllJobs() {
		// TODO Auto-generated method stub
		return jobRepository.findAll().stream().map((x) -> x.toDTO()).toList();
	}

	@Override
	public JobDTO getJob(Long id) throws BlueCollarException {
		// TODO Auto-generated method stub
		return jobRepository.findById(id).orElseThrow(() -> new BlueCollarException("JOB_NOT_FOUND")).toDTO();
	}
}
