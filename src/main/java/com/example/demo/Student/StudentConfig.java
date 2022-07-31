package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner (StudentRepo repo)
    {
        return args ->
        {
            Student ali =new Student (
                    "Ali",
                    "ALi@m.com",
                    of(1998,3,22));
            Student ahmed =new Student (
                    "Ahmed",
                    "Ahmed123@m.com",
                    of(1997,11,27));
            Student assem =new Student (
                    "Asem",
                    "Asem123@m.com",
                    of(1998,8,15));
            repo.saveAll(List.of(ali,ahmed,assem));
        };
    }
}
