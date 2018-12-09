package com.aakash.rest.authentication;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.aakash.rest.person.model.Person;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenProvider {
	static final long EXPIRATIONTIME = 864_000_000; // 10 days
	  static final String SECRET = "ThisIsASecret";
	  static final String TOKEN_PREFIX = "Bearer";
	  static final String HEADER_STRING = "Authorization";

	  public static void addAuthentication(HttpServletResponse res, Authentication auth) {
	    String JWT = Jwts.builder()
	    	.setSubject(String.valueOf(((Person) auth.getPrincipal()).getId()))
	        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
	        .signWith(SignatureAlgorithm.HS512, SECRET)
	        .compact();
	    
	    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	  }

	  public static Authentication getAuthentication(HttpServletRequest request) {
	    String token = request.getHeader(HEADER_STRING);
	    if (token != null) {
	      // parse the token.
	      String user = Jwts.parser()
	          .setSigningKey(SECRET)
	          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
	          .getBody()
	          .getSubject();
	      
	      return user != null ?
	          new UsernamePasswordAuthenticationToken(user, null, new ArrayList()) :
	          null;
	    }
	    return null;
	  }
}

