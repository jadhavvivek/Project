package com.example.Project_Status.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Project_Status.Model.ProjectStatus;
import com.example.Project_Status.repository.ProjectStatusRepository;

@Service
public class ProjectStatusService {
@Autowired
ProjectStatusRepository projectstatusrepository;


public void addStatusInfo(ProjectStatus status) {
	projectstatusrepository.save(status);
}



public List<ProjectStatus>getAllStatus(){
	return projectstatusrepository.findAll();
}


public Optional<ProjectStatus> getStatusById(int projectStatusId) {
    return projectstatusrepository.findById(projectStatusId);
}


public ProjectStatus updateProjectStatus(int Id, ProjectStatus projectStatus) {
	  Optional<ProjectStatus> existingProjectStatus = projectstatusrepository.findById(Id);
    if (!existingProjectStatus.isPresent()) {
        return null;
    }
    ProjectStatus updatedProjectStatus = projectstatusrepository.save(projectStatus);
    return updatedProjectStatus;
}




public boolean deleteProjectStatus(int Id) {
 Optional<ProjectStatus>Status=projectstatusrepository.findById(Id);
 if(Status.isPresent()) {
	 projectstatusrepository.delete(Status.get());
	 return true;
	 
 }else
 {
	 return false;
 }
}
}