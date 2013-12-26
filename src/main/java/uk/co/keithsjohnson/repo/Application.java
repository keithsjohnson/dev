package uk.co.keithsjohnson.repo;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import uk.co.keithsjohnson.entity.Build;

@Configuration
@EnableJpaRepositories
public class Application {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(H2).build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setPackagesToScan(new String[] { "uk.co.keithsjohnson.entity" });
		return lef;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.H2);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				Application.class);
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
		List<Build> kims = repository.findByName("Kim");
		System.out.println("Build found with findByName('Kim'):");
		System.out.println("--------------------------------------------");
		for (Build kim : kims) {
			System.out.println(kim);
		}

		context.close();
	}

}
