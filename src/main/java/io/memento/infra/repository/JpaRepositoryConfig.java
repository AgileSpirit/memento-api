package io.memento.infra.repository;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static io.memento.infra.util.PropertyHelper.setProperty;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("io.memento.infra.repository")
public class JpaRepositoryConfig {

    @Inject
    private Environment env;

    @Inject
    private DataSource dataSource;

    /*
     * JPA
     */

    @Bean
    public Properties jpaProperties() {
        Properties properties = new Properties();

        // Hibernate properties
//        setProperty(env, properties, "hibernate.dialect");
        setProperty(env, properties, "hibernate.show_sql");
        setProperty(env, properties, "hibernate.hbm2ddl.auto");
        setProperty(env, properties, "hibernate.generate_statistics");
        setProperty(env, properties, "hibernate.archive.autodetection");
        setProperty(env, properties, "hibernate.use_sql_comments");
        setProperty(env, properties, "hibernate.format_sql");
        setProperty(env, properties, "hibernate.connection.autocommit");

        return properties;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setDataSource(dataSource);
        factory.setPersistenceProvider(new HibernatePersistenceProvider());
        factory.setJpaProperties(jpaProperties());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

}
