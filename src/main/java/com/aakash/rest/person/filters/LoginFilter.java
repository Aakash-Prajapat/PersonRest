package com.aakash.rest.person.filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.aakash.rest.authentication.TokenProvider;
import com.aakash.rest.person.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;



public class LoginFilter extends  AbstractAuthenticationProcessingFilter {
	
    public LoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}


	private AuthenticationManager authenticationManager;


	@Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            Person person = new ObjectMapper()
                    .readValue(req.getInputStream(), Person.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            String.valueOf(person.getId()),
                            person.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	
	@Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
		TokenProvider.addAuthentication(res, auth);
    }

	

}
