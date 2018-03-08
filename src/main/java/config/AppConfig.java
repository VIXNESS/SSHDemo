package config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * @author Jiang
 */
//Don't amend any functions unless you want to change the file sketch
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"dao.impl", "service.impl", "action"})//This MUST match target packages.
public class AppConfig {
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setConfigLocations(new ClassPathResource("hibernate.cfg.xml"));
        return sessionFactoryBean;
    }

    @Bean
    @Resource(name = "sessionFactory")
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}