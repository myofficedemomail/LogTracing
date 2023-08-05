package com.softtek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AppEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	private String applicationName;
	private String serverName;
}
