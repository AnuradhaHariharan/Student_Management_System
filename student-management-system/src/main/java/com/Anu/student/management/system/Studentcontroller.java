package com.Anu.student.management.system;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
public class Studentcontroller { //will be writing APIs

    Map<Integer,Student> db=new HashMap<>(); //using as data base,key is admin no and value is student object

    @GetMapping("/getInfo")//to mark the end point
    Student getStudent(@RequestParam("id") int adminNo){
        return db.get(adminNo);
    }

    @PostMapping("/add") //for manipulating info in db
    String addStudent(@RequestBody() Student student){
        db.put(student.getAdminNo(), student);
        return "Student has been added succesfully";
    }
    @DeleteMapping("/delete/{id}")
    String deletestudent(@PathVariable("id") int adminNo){
        db.remove(adminNo);
        return "Student Removed";
    }
}
