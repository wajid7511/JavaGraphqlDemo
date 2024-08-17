package com.graphql.demo.graphql.Core;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.graphql.demo.graphql.Database.Student;

public interface IStudentRepository extends MongoRepository<Student, String> {
    @Query("{name:'?0'}")
    Student findStudentByName(String name);

    @Query(value = "{contactNumber:'?0'}", fields = "{'name' : 1, 'contactNumber' : 1, 'email' : 1}")
    List<Student> findAll(String contactNumber);

    public long count();
}
