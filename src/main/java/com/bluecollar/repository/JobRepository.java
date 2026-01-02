package com.bluecollar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluecollar.entity.Job;

public interface JobRepository extends MongoRepository<Job, Long> {

}
