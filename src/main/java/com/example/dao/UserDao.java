package com.example.dao;

import com.example.mapper.UserMapper;
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

    private final UserMapper userMapper;

    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    public Optional<User> getUserByEmail(String email) {
    	return Optional.ofNullable(userMapper.getUserByEmail(email));
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