package cn.codeforfun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "cn.codeforfun.dao")
public class JpaConfig {
}
