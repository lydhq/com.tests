package com.tests.dao;

import com.tests.entity.Student;

import java.util.Collection;

public interface StudentDao {
    public Collection<Student> findAll();
    public Student findById(long id);
    public void AddStudent(Student student);
    public void deleteById(long id);

}
