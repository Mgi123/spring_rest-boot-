package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.Coursedao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {
	@Autowired
	private Coursedao coursedao;

	// List<Course> list;

	public CourseServiceimpl() {

//		list = new ArrayList<>();
//		list.add(new Course(145, "JAVA", "MATSERING JAVA BY MUKUL "));
//		list.add(new Course(146, "JAVA ADVANCE", "MATSERING JAVA ADVANCE  BY KING "));

	}

	@Override
	public List<Course> getCourses() {

		return coursedao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		return coursedao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		coursedao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {

//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//
//			}
//		});
		coursedao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
		Course entity = coursedao.getOne(parseLong);
		coursedao.delete(entity);

	}

}
