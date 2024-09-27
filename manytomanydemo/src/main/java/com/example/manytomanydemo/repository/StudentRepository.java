package com.example.manytomanydemo.repository;

import com.example.manytomanydemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
