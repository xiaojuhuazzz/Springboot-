package com.example01.springboot;

/*
    使用Spring Security例子
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//通过@EnableWebSecurity注解开启Spring Security的功能
//继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index2", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login2")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
    /*
        通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
        例如以上代码指定了/index2和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。

        通过formLogin()定义当需要用户登录时候，转到的登录页面
     */

    //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("UESR");
    }
    /*
        通过@Autowired自动装配方式，从IoC容器中去查找到，并返回给该属性
        在启动spring IoC时，容器自动装载了一个AutowiredAnnotationBeanPostProcessor后置处理器，
        当容器扫描到@Autowied、@Resource或@Inject时，就会在IoC容器自动查找需要的bean，并装配给该对象的属性
     */
}
