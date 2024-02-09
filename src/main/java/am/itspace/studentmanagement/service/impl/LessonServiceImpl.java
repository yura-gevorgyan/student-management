package am.itspace.studentmanagement.service.impl;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.repository.LessonRepository;
import am.itspace.studentmanagement.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Override
    public void save(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public Lesson findByTeacher(User user) {
        return lessonRepository.findByUser(user).orElse(null);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(int id) {
        return lessonRepository.findById(id).orElse(null);
    }
}
