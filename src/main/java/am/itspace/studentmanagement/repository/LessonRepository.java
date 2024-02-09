package am.itspace.studentmanagement.repository;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Optional<Lesson> findByUser(User user);


}
