package com.example.dbentity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ImgLog {

	@Id
	int id;
	String value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Dbentity [id=" + id + ", value=" + value + "]";
	}
	
	
}
