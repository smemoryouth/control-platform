package com.lyzd.controlplatform.web.config;

import com.lyzd.controlplatform.web.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginAndAclFilterConfig {


    @Bean
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public FilterRegistrationBean loginFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoginFilter());
        List<String> urlList = new ArrayList<String>();
        urlList.add("/sys/*");
        registration.setUrlPatterns(urlList);
        registration.setName("LoginFilter");
        registration.setOrder(1);
        return registration;
    }
}
