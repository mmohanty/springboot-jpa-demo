package com.manas.springboot.demo.jpa.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.manas.springboot.demo.jpa.repository", transactionManagerRef = "jpaTransactionManager")
//@PropertySource(value = { "classpath:config.properties" })
@EnableTransactionManagement
public class JpaConfig {

    private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = { "com.manas.springboot.demo.jpa.entity" };

    @Autowired
    private Environment env;

  /**  @Bean
    public DataSource dataSource() {

        String username  = System.getenv("spring.datasource.username");
        String password  = System.getenv("spring.datasource.password");
        String url  = System.getenv("spring.datasource.url");

       // String username = env.getProperty("spring.datasource.username");
       // String password = env.getProperty("spring.datasource.password");
        String driverClass = env.getProperty("spring.datasource.driver-class-name");
       // String url = env.getProperty("spring.datasource.url");

        return DataSourceBuilder.create().username(username).password(password).url(url).driverClassName(driverClass)
                .build();
    }*/


      @Bean(name="customDataSource")
      @ConfigurationProperties("spring.hikari.datasource")
      public DataSource customDataSource() {
          return DataSourceBuilder.create().build();
      }

    @Bean
    public JpaTransactionManager jpaTransactionManager(@Autowired DataSource customDataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory(customDataSource).getObject());
        return transactionManager;
    }

    //adding for future use
    private HibernateJpaVendorAdapter vendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        return vendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired DataSource customDataSource) {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
       // entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setDataSource(customDataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(addProperties());

        return entityManagerFactoryBean;
    }

    private Properties addProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
        properties.setProperty("current_session_context_class", env.getProperty("spring.jpa.properties.current_session_context_class"));
       // properties.setProperty("spring.jpa.open-in-view", env.getProperty("spring.jpa.open-in-view"));
        // we can add
        return properties;
    }
}
