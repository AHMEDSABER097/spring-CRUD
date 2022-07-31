package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
private static StudentRepo studentRepo ;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public static void addStudent(Student student)
    {
        Optional<Student> sbe = studentRepo.findStudentByEmail(student.getEmail());
        if (sbe.isPresent())
        {
            throw new IllegalStateException("taken");

        }
        studentRepo.save(student);
    }


    public List<Student> getStudent()
    {
        return studentRepo.findAll();
    };

public void deleteStudent(Long studentId)
{
    boolean b = studentRepo.existsById(studentId);
    if (!b)
    {
        throw new IllegalStateException("not Exist");
    }
    studentRepo.deleteById(studentId);
}

@Transactional
    public void updateStudent(long studentId , String name , String email) {
    Student student = studentRepo.findById(studentId).orElseThrow(
            ()-> new IllegalStateException("student d not exist"));
        if (name != null && name.length() > 0&& !Objects.equals(student.getName(),name))
        {
            student.setName(name);


        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email))
        {
            Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
            if (studentOptional.isPresent())
            {
                throw new IllegalStateException("email is taken ");

            }
            student.setEmail(email);
        }

    }
}

