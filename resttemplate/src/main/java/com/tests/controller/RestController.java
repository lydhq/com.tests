package com.tests.controller;

import com.tests.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
     return restTemplate.getForEntity("http://localhost:8081/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://provider/student/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return  restTemplate.getForEntity("http://localhost:8081/student/findById/{id}",Student.class,id).getBody();
    }

    @GetMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id") long id){
        return  restTemplate.getForObject("http://localhost:8081/student/findById/{id}",Student.class,id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8081/student/AddStudent",student,null).getBody();
    }

    @PostMapping("/add2")
    public void add2(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8081/student/AddStudent",student,null);
    }

    @PutMapping("/update")
    public void  update(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8081/student/updateStduent",student,null).getBody();
    }

    @PutMapping("/update2")
    public void  update2(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8081/student/updateStduent",student,null);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8081/student/deleteById/{id}",id);
    }
}
