package com.larkbird.config;

import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * Created by lordorr on 2017/3/17.
 */
@Configuration
public class DruidDataSourceConfig  implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

    @Bean
    public DataSource dataSource() {
        System.out.println("注入druid！！！");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("druid.initial-size")));
        datasource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("druid.min-idle")));
        datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty("druid.max-wait")));
        datasource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("druid.max-active")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("druid.min-evictable-idle-time-millis")));
        datasource.setPoolPreparedStatements(Boolean.valueOf(propertyResolver.getProperty("druid.pool-prepared-statement")));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(propertyResolver.getProperty("druid.max-pool-prepared-statement-per-connection-size")));
        datasource.setValidationQuery(propertyResolver.getProperty("druid.validation-query"));
        //datasource.setFilters(propertyResolver.getProperty("druid.filters"));
       // datasource.setConnectProperties(propertyResolver.getProperty("druid.connection-properties"));
        datasource.setUseGlobalDataSourceStat(Boolean.valueOf(propertyResolver.getProperty("druid.use-global-datasource-stat")));
        try {
            datasource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }
}
