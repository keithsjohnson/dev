package uk.co.keithsjohnson.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuildRepository extends CrudRepository<Build, Long> {

	List<Build> findByName(String name);
}
