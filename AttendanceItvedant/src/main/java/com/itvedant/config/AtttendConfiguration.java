package com.itvedant.config;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.itvedant.repo.AttendRepo")
@PropertySource("classpath:application.properties")
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
public class AtttendConfiguration {
	
	
	private final String DRIVER 		= "db.driver";
	private final String URL 			= "db.url";
	private final String USERNAME 		= "db.user";
	private final String PASSWORD 		= "db.password";
	
	
	private final String MINPOOLSIZE 			= "db.minpool";
	private final String MAXPOOLSIZE 			= "db.maxpool";
	private final String CONNECTIONTIMEOUT 	= "db.timeout";
	private final String MAXLIFETIME			= "db.maxlife";
	private final String KEEPALIVETIME 		= "db.keepalive";
	private final String SHOWSQL 		= "db.showsql";
//	private final String DIALECT 		= "db.dialtect";
	
	@Autowired
	Environment environment;

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		lfb.setDataSource(dataSource());
		lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lfb.setPackagesToScan("com.itvedant.model");
		lfb.setJpaProperties(hibernateProps());
		return lfb;
	}

	@Bean
	DataSource dataSource() {
	
	    HikariConfig config = new HikariConfig();
	    config.setJdbcUrl(environment.getProperty(URL));
	    config.setUsername(environment.getProperty(USERNAME));
	    config.setPassword(environment.getProperty(PASSWORD));
	    config.setDriverClassName(environment.getProperty(DRIVER));
	    config.setConnectionTestQuery("select 1");

		config.setMinimumIdle(Integer.parseInt(environment.getProperty(MINPOOLSIZE, "5")));

		config.setMaximumPoolSize(Integer.parseInt(environment.getProperty(MAXPOOLSIZE, "10")));

		config.setConnectionTimeout(Integer.parseInt(environment.getProperty(CONNECTIONTIMEOUT, "30000")));

		 config.setKeepaliveTime(Integer.parseInt(environment.getProperty(KEEPALIVETIME,"600000")));

		config.setMaxLifetime(Integer.parseInt(environment.getProperty(MAXLIFETIME, "1800000")));

		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
	    
	    DataSource datasource = new HikariDataSource(config);
	    
		return datasource;
	}

	Properties hibernateProps() {
		Properties properties = new Properties();
//		properties.setProperty("hibernate.dialect", environment.getProperty(DIALECT));
		properties.setProperty("hibernate.show_sql", environment.getProperty(SHOWSQL));
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
		return properties;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	 @Bean(name = "auditingDateTimeProvider")
	    public DateTimeProvider dateTimeProvider() {
	        return () -> Optional.of(OffsetDateTime.now());
	    }


}
