package com.graphql.demo.graphql;

import org.springframework.web.bind.annotation.RestController;
import com.graphql.demo.graphql.Core.IStudentRepository;
import com.graphql.demo.graphql.Database.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class StudentController {
    @Autowired
    IStudentRepository studentRepository;

    @GetMapping("/student/byName")
    public Student getStudentByName(@RequestParam String name) {
        return studentRepository.findStudentByName(name);
    }

    @GetMapping("/student/allByContactNumber")
    public List<Student> getStudentAllByName(@RequestParam String contactNumber) {
        return studentRepository.findAll(contactNumber);
    }

    @GetMapping("/message")
    public String getMessage() {
        return "This is my first api in Sprint boot";
    }

    @GetMapping("/message/byId")
    public String getMessageById(@RequestParam int id) {
        return String.format("This is my first api in Sprint boot %s", id);
    }

    @PostMapping("/message")
    public String postMesasge(@RequestBody String name) {

        return name;
    }

    @PutMapping("/message/{id}")
    public String putMesasge(@PathVariable String id, @RequestBody String name) {

        return name;
    }

    @DeleteMapping("/delete")
    public boolean deleteMesasge() {
        return true;
    }

}
