package am.itspace.studentmanagement.service;

import am.itspace.studentmanagement.entity.Lesson;
import am.itspace.studentmanagement.entity.User;
import am.itspace.studentmanagement.entity.UserType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User findByEmail(String email);

    void save(User user, MultipartFile multipartFile) throws IOException;

    List<User> findAllByLessonAndUserType(Lesson lesson, UserType userType);

    void saveUser(User user);

}
