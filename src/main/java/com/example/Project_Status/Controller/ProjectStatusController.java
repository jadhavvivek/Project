package com.example.Project_Status.Controller;


import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Project_Status.Model.ProjectStatus;
import com.example.Project_Status.Service.ProjectStatusService;
import com.example.Project_Status.repository.ProjectStatusRepository;

import jakarta.validation.Valid;

@RestController
public class ProjectStatusController {
	@Autowired
	ProjectStatusService projectstatusservice;
	ProjectStatusRepository projectstatusrepository;
	
	
	@PostMapping("/project_status")
    public String addStatusInfo(@Valid @RequestBody ProjectStatus projectstatus) {
	projectstatusservice.addStatusInfo(projectstatus);
	return "success";
	}
	
	/*
	@PostMapping("/project_status")
    public ResponseEntity<String> addStatusInfo(@Valid @RequestBody ProjectStatus projectstatus, BindingResult result) {
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body("Validation error");
		}
		projectstatusservice.addStatusInfo(projectstatus);
		return ResponseEntity.ok("success");
	}
	*/
@GetMapping("/project_status")
public List<ProjectStatus>getAllStatus(){
return projectstatusservice.getAllStatus();
	}




@GetMapping("/project_status/{projectStatusId}")
public ResponseEntity<ProjectStatus> getProjectStatusById(@PathVariable int projectStatusId) {
    Optional<ProjectStatus> projectStatus = projectstatusservice.getProjectStatusById(projectStatusId);
    if (projectStatus.isPresent()) {
        return ResponseEntity.ok(projectStatus.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}


@PutMapping("/project_status/{project_status_id}")
public ResponseEntity<ProjectStatus> updateProjectStatus(@PathVariable int project_status_id, @RequestBody ProjectStatus projectStatus) {
    ProjectStatus updatedProjectStatus = projectstatusservice.updateProjectStatus(project_status_id, projectStatus);

   if (updatedProjectStatus == null) {
   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   } else {
        return new ResponseEntity<>(updatedProjectStatus, HttpStatus.OK);
    }
   }


        @DeleteMapping("/deleteProjectStatus/{Id}")
        public ResponseEntity<String> deleteProjectStatus(@PathVariable int Id) {
        boolean message =projectstatusservice.deleteProjectStatus(Id);

         if (message) {
        	 return new ResponseEntity<>("Status deleted", HttpStatus.OK);
         }else {
        	 return new ResponseEntity<>("Status not found", HttpStatus.NOT_FOUND);
        	 
        
    	}
}
}
