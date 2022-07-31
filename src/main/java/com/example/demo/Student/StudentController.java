package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
   private final StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }
    @GetMapping
    public List<Student>getStudent()
    {return studentService.getStudent() ;}



    @PostMapping
    public void registerNewStudent(Student student)
    {
        StudentService.addStudent(student);

    }

    @DeleteMapping (path = "{studentId}")
    public void deleteS(@PathVariable("studentId") long studentId)
    {
    studentService.deleteStudent(studentId);
    }

@PutMapping(path = "{studentId}")
    public void updateStudent (@PathVariable ("studentId")  long studentId
    ,@RequestParam (required = false) String name , @RequestParam (required = false) String email)
    {
        studentService.updateStudent(studentId,name,email);}

}
