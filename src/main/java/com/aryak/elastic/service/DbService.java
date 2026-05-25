package com.aryak.elastic.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DbService {

    private final JdbcTemplate jdbcTemplate;

    public DbService(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.execute("DROP TABLE IF EXISTS employee");

    }

    public void executeDbCalls() {

        jdbcTemplate.execute("""
                    CREATE TABLE IF NOT EXISTS employee(
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100)
                    )
                """);

        jdbcTemplate.update(
                "INSERT INTO employee(name) VALUES (?)",
                "Aryak"
        );

        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM employee",
                Integer.class
        );

        log.info("Employee count={}", count);
    }
}
