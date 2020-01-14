package com.krupp.scaffolding.eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


/**
 * 配置Security
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @Description: 高版本的丢弃了
     * security:
     *   basic:
     *     enabled: true 配置，应该使用以下方式开启
     * @Param: [http]
     * @Return: void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure HttpSecurity as needed (e.g. enable http basic).
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        //注意：为了可以使用 http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录,所以必须是httpBasic,
        // 如果是form方式,不能使用url格式登录
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/**").permitAll() //取消安全验证
                .anyRequest()
                .authenticated().and().httpBasic();

       /*
        System.out.println("================WebSecurityConfig================");
        http.csrf().disable();
        http.authorizeRequests()// 拦截请求，创建了FilterSecurityInterceptor拦截器
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()// 设置所有请求都得经过认证后才可以访问
                .and()// 用and来表示配置过滤器结束，以便进行下一个过滤器的创建和配置
                .formLogin()// 设置表单登录，创建TSysUsernamePasswordAuthenticationFilter拦截器
                .permitAll();// 开启HTTP Basic，创建BasicAuthenticationFilter拦截器
        */
    }
}
