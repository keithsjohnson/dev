package uk.co.keithsjohnson.main;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.keithsjohnson.entity.Build;
import uk.co.keithsjohnson.repo.BuildRepository;

public class BuildRepositoryJUnitTest {

	private BuildRepository testSubject;

	private AbstractApplicationContext context;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		testSubject = context.getBean(BuildRepository.class);
	}

	@After
	public void teardown() {
		context.close();
	}

	@Test
	public void shouldBuildRepository() {

		// save a 5 of Builds
		testSubject.save(new Build("Jack"));
		testSubject.save(new Build("Chloe"));
		testSubject.save(new Build("Kim"));
		testSubject.save(new Build("David"));
		testSubject.save(new Build("Michelle"));

		// fetch all Builds
		Iterable<Build> builds = testSubject.findAll();
		System.out.println("Builds found with findAll():");
		System.out.println("-------------------------------");
		for (Build build : builds) {
			System.out.println(build);
		}
		System.out.println();

		// fetch an individual Build by ID
		Build build = testSubject.findOne(1L);
		System.out.println("Build found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(build);
		System.out.println();

		// fetch Builds by name
		List<Build> names = testSubject.findByName("Jack");
		System.out.println("Build found with findByName('Jack'):");
		System.out.println("--------------------------------------------");
		for (Build name : names) {
			System.out.println(name);
		}
	}

	@Test
	public void shouldBuildRepository2() {

		// save a 5 of Builds
		testSubject.save(new Build("Jack"));
		testSubject.save(new Build("Chloe"));
		testSubject.save(new Build("Kim"));
		testSubject.save(new Build("David"));
		testSubject.save(new Build("Michelle"));

		// fetch all Builds
		Iterable<Build> builds = testSubject.findAll();
		System.out.println("Builds found with findAll():");
		System.out.println("-------------------------------");
		for (Build build : builds) {
			System.out.println(build);
		}
		System.out.println();

		// fetch an individual Build by ID
		Build build = testSubject.findOne(2L);
		System.out.println("Build found with findOne(2L):");
		System.out.println("--------------------------------");
		System.out.println(build);
		System.out.println();

		// fetch Builds by name
		List<Build> names = testSubject.findByName("Kim");
		System.out.println("Build found with findByName('Kim'):");
		System.out.println("--------------------------------------------");
		for (Build name : names) {
			System.out.println(name);
		}
	}

}
