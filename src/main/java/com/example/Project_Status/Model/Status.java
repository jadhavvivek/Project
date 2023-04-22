package com.example.Project_Status.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Status {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = " Status_id cannot be blank.")
	@Size(min = 1, max = 20, message = "Status ID must be between 1 and 20 characters.")
	@Column(name="Status")
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
