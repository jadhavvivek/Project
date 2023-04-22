package com.example.Project_Status.Model;

import jakarta.persistence.Column;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class ProjectStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	
	@NotBlank(message = " Project_id cannot be blank.")
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}$", message = "Project ID must be in the format ABC-123.")
	@Column(name="Project_id")
	private String project_id;

	@NotBlank(message = " Status_id cannot be blank.")
	@Size(min = 1, max = 20, message = "Status ID must be between 1 and 20 characters.")
	@Column(name="Status_id")
	private String status_id;
	
	@NotBlank(message = " Client_id cannot be blank.")
	@Column(name="Client_id")
	private String client_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	

	
	
}
