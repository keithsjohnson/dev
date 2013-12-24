package uk.co.keithsjohnson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Build {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

	protected Build() {
	}

	public Build(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Build[id=%d, bame='%s']", id, name);
	}
}
