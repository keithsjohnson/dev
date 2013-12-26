package uk.co.keithsjohnson.main;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.keithsjohnson.entity.Build;
import uk.co.keithsjohnson.repo.BuildRepository;

public class BuildRepositoryJUnitTest {

	@Test
	public void shouldBuildRepository() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");
		BuildRepository repository = context.getBean(BuildRepository.class);

		// save a couple of Builds
		repository.save(new Build("Jack"));
		repository.save(new Build("Chloe"));
		repository.save(new Build("Kim"));
		repository.save(new Build("David"));
		repository.save(new Build("Michelle"));

		// fetch all Builds
		Iterable<Build> Builds = repository.findAll();
		System.out.println("Builds found with findAll():");
		System.out.println("-------------------------------");
		for (Build Build : Builds) {
			System.out.println(Build);
		}
		System.out.println();

		// fetch an individual Build by ID
		Build Build = repository.findOne(1L);
		System.out.println("Build found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(Build);
		System.out.println();

		// fetch Builds by name
		List<Build> jacks = repository.findByName("Jack");
		System.out.println("Build found with findByName('Jack'):");
		System.out.println("--------------------------------------------");
		for (Build jack : jacks) {
			System.out.println(jack);
		}

		context.close();
	}

}
