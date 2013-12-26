package uk.co.keithsjohnson.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.entity.Build;

@Component
public interface BuildRepository extends CrudRepository<Build, Long> {

	List<Build> findByName(String name);
}
