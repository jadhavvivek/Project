package com.example.Project_Status.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Project_Status.Model.ProjectStatus;


public interface ProjectStatusRepository extends JpaRepository<ProjectStatus,Integer> {

	

}
