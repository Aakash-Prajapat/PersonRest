package com.aakash.rest.person.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aakash.rest.person.model.Person;

public class PersonMapper implements RowMapper<Person>{
	
	public Person mapRow(ResultSet rs, int rownumber) throws SQLException {  
        Person person=new Person();  
        person.setId(rs.getInt("id"));  
        person.setName(rs.getString("name"));  
        person.setBio(rs.getString("bio"));  
        person.setEmail(rs.getString("email")); 
        person.setTeamid(rs.getInt("teamid")); 
        person.setDepartment(rs.getString("department")); 
        person.setPassword(rs.getString("password")); 
        return person;  
    }  

}
