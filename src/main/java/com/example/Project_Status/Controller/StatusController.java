package com.example.Project_Status.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Project_Status.Model.Status;
import com.example.Project_Status.Service.StatusService;
import com.example.Project_Status.repository.StatusRepository;



@RestController
public class StatusController {
	@Autowired
	StatusService statusservice;
	StatusRepository statusrepository;
	
	
	
	@PostMapping("/status")
    public String getStatus(@RequestBody Status status) {
    statusservice.getStatus(status);
	return "success";
	}
	
	
	
@GetMapping("/status")
public List<Status> getAllStatus(){
return statusservice.getAllStatus();
}
	
	
	
	@GetMapping("/status/{StatusId}")
	public Optional<Status> getStatusById(@PathVariable int StatusId) {
	return statusservice.getStatusById(StatusId);
	}
	
	
	
	@PutMapping("status/{statusId}")
	public ResponseEntity<Status> updateStatus(@PathVariable int statusId,@RequestBody Status status) {
		Status updateStatus=statusservice.updateStatus(statusId,status);
		 if (updateStatus == null) {
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
			    return new ResponseEntity<>(updateStatus, HttpStatus.OK);
			   }
			   
		
	}
	
	    
	    
	   @DeleteMapping("/deleteStatus/{Id}")
       public ResponseEntity<String> deleteStatus(@PathVariable int Id) {
       boolean success =statusservice.deleteStatus(Id);

        if (success) {
       	 return new ResponseEntity<>("Status deleted", HttpStatus.OK);
        }else {
       	 return new ResponseEntity<>("Status not found", HttpStatus.NOT_FOUND);
       	 
       
   	}
	}
}

