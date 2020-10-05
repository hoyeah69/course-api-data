package com.hoyeah.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    
    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        //CourseRepository.findAll().forEach(Courses::add);
        courseRepository.findByTopicId(topicId).forEach(t -> courses.add(t));
        return courses;
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course Course) {
        courseRepository.save(Course);
    }

    public void updateCourse(String id, Course Course) {
        courseRepository.save(Course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
