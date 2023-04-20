package com.example.Project_Status.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project_Status.Model.ProjectStatus;
import com.example.Project_Status.Model.Status;

public interface StatusRepository extends JpaRepository<Status,Integer>{

	ProjectStatus save(ProjectStatus status);
	
}
