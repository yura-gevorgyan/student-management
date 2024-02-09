package am.itspace.studentmanagement.service;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;

import java.util.List;

public interface LessonService {

    void save(Lesson lesson);

    Lesson findByTeacher(User user);

    List<Lesson> findAll();

    Lesson findById(int id);
}
