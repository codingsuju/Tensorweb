package com.courses.controllers;

import com.courses.models.Course;
import com.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("/api/course/hello")
    public String sayHello(){
        return "Hello World from Course";
    }
    @GetMapping("/api/course/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
    @GetMapping("/api/course/course/{id}")
    public Course getCourse(@PathVariable Integer courseid){
        return courseRepository.findByCourseid(courseid);
    }
    @PostMapping("/api/course/user/{username}/course")
    public Course addCourse(@PathVariable String username, Course course){
        if(courseRepository.findByCourseid(course.getCourseid())!=null){
            return new Course();
        }
        return courseRepository.save(course);
    }
    @PutMapping("/api/course/user/{username}/course")
    public Course updateProfile(@PathVariable String username, Course course){
        if(courseRepository.findByCourseid(course.getCourseid())==null){
            return new Course();
        }
        return courseRepository.save(course);
    }
    @GetMapping("/api/course/courses/init/delete")
    public String delete(){
        courseRepository.deleteAll();
        return "Success OK!!";
    }
}
