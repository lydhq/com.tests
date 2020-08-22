package com.tests.controller;

import com.tests.entity.Student;
import com.tests.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/findById/{id}")
    public  Student findById(@PathVariable("id") long id){
        return studentService.findById(id);
    }
    @PostMapping("/AddStudent")
    public void AddStudent(@RequestBody Student student){
        studentService.AddStudent(student);
    }
    @PutMapping("/updateStduent")
    public void updateStduent(@RequestBody Student student){
        studentService.AddStudent(student);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        studentService.deleteById(id);
    }
    @GetMapping("/index")
    public String index(){
        return "当前端口："+this.port;
    }
}
