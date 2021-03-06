package com.foodhotelics.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.foodhotelics.demo.service.UserService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
@Autowired 
private UserService userService;


@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
   .antMatchers("/","/signUp").permitAll().anyRequest().authenticated().and().
   formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/userWelcome").and().
   logout().invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll().and().exceptionHandling().accessDeniedPage("/403").and().csrf();
               
}

@Bean(name="passwordencoder")
public BCryptPasswordEncoder passwordencoder(){
	return new BCryptPasswordEncoder();
}

@Bean
public DaoAuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    auth.setUserDetailsService(userService);
    auth.setPasswordEncoder(passwordencoder());
    return auth;
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
}

	


}
