package uk.co.keithsjohnson.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import uk.co.keithsjohnson.entity.Build;

public interface BuildRepository extends CrudRepository<Build, Long> {

	List<Build> findByName(String name);
}
