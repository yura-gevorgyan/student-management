package am.itspace.studentmanagement.repository;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    List<User> findAllByLessonAndUserType(Lesson lesson, UserType userType);

}
