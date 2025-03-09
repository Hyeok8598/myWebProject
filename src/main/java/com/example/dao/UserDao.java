package com.example.dao;

import com.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public Optional<User> getUserByEmail(String email) {
    	String sql = "SELECT id, name, email, password FROM users WHERE email = ?";
    	return jdbcTemplate.query(sql,  userRowMapper, email).stream().findFirst();
    }
    
    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
    	User user = new User();
    	user.setId(rs.getLong("id"));
    	user.setName(rs.getString("name"));
    	user.setEmail(rs.getString("email"));
    	user.setPassword(rs.getString("password"));
    	
    	return user;
    };
}
