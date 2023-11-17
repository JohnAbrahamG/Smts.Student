package com.example.Smts.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Smts.Student.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
