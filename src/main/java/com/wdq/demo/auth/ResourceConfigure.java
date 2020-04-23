/**
 * 
 */
package com.wdq.demo.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> wangdingqiang
 * <b>Date:</b> 2020年4月21日 上午11:30:06
 * <b>Copyright:</b> Copyright &copy;2020-2030 wdq Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2020年4月21日 上午11:30:06   wangdingqiang
 *         new file.
 * </pre>
 */
@EnableResourceServer
@Configuration
public class ResourceConfigure extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("rid");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
			      .antMatchers("/user/**").authenticated()// 只是告知授权才能访问
			      .antMatchers("/test/**").hasRole("ADMIN");// 当密码授权访问时，告知哪个角色能访问
    }
}
